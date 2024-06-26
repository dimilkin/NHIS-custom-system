package com.nzis.ignatovsoft.nhis.services;

import com.nzis.ignatovsoft.dataservices.ExamsDataService;
import com.nzis.ignatovsoft.dtos.ExamDTO;
import com.nzis.ignatovsoft.dtos.PatientDTO;
import com.nzis.ignatovsoft.nhis.models.nhis.x002.Message002;
import com.nzis.ignatovsoft.nhis.services.mappers.ExamClosingBodyX003Marshalling;
import com.nzis.ignatovsoft.nhis.services.mappers.InitialExamOpenerMarshaling;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class NetworkServiceImpl implements NetworkService {

    private final DigitalSignatureImpl digitalSignee = new DigitalSignatureImpl();
    private AuthenticationService authService;
    private ExamsDataService examsDataService;

    public NetworkServiceImpl() {
        authService = new AuthenticationService();
        examsDataService = new ExamsDataService();
    }

    @Override
    public String sendExaminationOpenRequestX001(PatientDTO patientDTO) {
        InitialExamOpenerMarshaling initialExamOpenerMarshaling = new InitialExamOpenerMarshaling();

        try {
            String requestPayload = initialExamOpenerMarshaling.getMarshaledRequestBody(patientDTO);
            String signedRequest = digitalSignee.signXml(requestPayload);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://ptest-api.his.bg/v3/eexamination/examination/open"))
                    .header("Content-Type", "application/xml")
                    .header("Authorization", "Bearer " + authService.getAccessToken())
                    .POST(HttpRequest.BodyPublishers.ofString(signedRequest))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JAXBContext jaxbContext = JAXBContext.newInstance(Message002.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Message002 message = (Message002) jaxbUnmarshaller.unmarshal(new StringReader(response.body()));

//            ExamDbModel examDbModel = new ExamDbModel();
//            examDbModel.setNrn(message.getNrnExamination().getValue());
//            examDbModel.setLrn(message.getLrn().getValue());
//            examsDataService.saveExam(examDbModel);

            return message.getContents().getNrnExamination().getValue();

        } catch (IOException | InterruptedException | JAXBException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public String sendExaminationCloseRequestX003(ExamDTO examDTO) {
        ExamClosingBodyX003Marshalling examClosingBodyX003Marshalling = new ExamClosingBodyX003Marshalling();

        try {
        String marshaledRequest = examClosingBodyX003Marshalling.getMarshalledRequestBody(examDTO);
        String signedRequest = digitalSignee.signXml(marshaledRequest);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://ptest-api.his.bg/v2/eexamination/examination/close"))
                .header("Content-Type", "application/xml")
                .header("Authorization", "Bearer " + authService.getAccessToken())
                .POST(HttpRequest.BodyPublishers.ofString(signedRequest))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
