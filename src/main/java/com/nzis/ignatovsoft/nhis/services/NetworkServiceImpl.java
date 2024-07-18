package com.nzis.ignatovsoft.nhis.services;

import com.nzis.ignatovsoft.dtos.ExamDTO;
import com.nzis.ignatovsoft.dtos.PatientDTO;
import com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002.Entry;
import com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002.MessageC002;
import com.nzis.ignatovsoft.nhis.models.nhis.x002.ContentsX002;
import com.nzis.ignatovsoft.nhis.models.nhis.x002.MessageX002;
import com.nzis.ignatovsoft.nhis.services.mappers.ExamClosingBodyX003Marshalling;
import com.nzis.ignatovsoft.nhis.services.mappers.InitialExamOpenerMarshaling;
import com.nzis.ignatovsoft.nhis.services.mappers.RequiredNomenclaturesMarshalling;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public class NetworkServiceImpl implements NetworkService {

    private final DigitalSignatureImpl digitalSignee = new DigitalSignatureImpl();
    private AuthenticationService authService;

    public NetworkServiceImpl() {
        authService = new AuthenticationService();
    }

    @Override
    public ContentsX002 sendExaminationOpenRequestX001(PatientDTO patientDTO) {
        InitialExamOpenerMarshaling initialExamOpenerMarshaling = new InitialExamOpenerMarshaling();

        try {
            String requestPayload = initialExamOpenerMarshaling.getMarshaledRequestBody(patientDTO);
            String signedRequest = digitalSignee.signXml(requestPayload);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://ptest-api.his.bg/v2/eexamination/examination/open"))
                    .header("Content-Type", "application/xml")
                    .header("Authorization", "Bearer " + authService.getAccessToken())
                    .POST(HttpRequest.BodyPublishers.ofString(signedRequest))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JAXBContext jaxbContext = JAXBContext.newInstance(MessageX002.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            MessageX002 message = (MessageX002) jaxbUnmarshaller.unmarshal(new StringReader(response.body()));

            return message.getContents();

        } catch (IOException | InterruptedException | JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int sendExaminationCloseRequestX003(ExamDTO examDTO) {
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

            return response.statusCode();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public CompletableFuture<List<Entry>> getNomenclaturesC002(String nome) {
        RequiredNomenclaturesMarshalling requiredNomenclaturesMarshalling = new RequiredNomenclaturesMarshalling();

        try {
            String marshaledRequest = requiredNomenclaturesMarshalling.getMarshalledRequestBody(nome);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://ptest-api.his.bg/v1/nomenclatures/all/get"))
                    .header("Content-Type", "application/xml")
                    .POST(HttpRequest.BodyPublishers.ofString(marshaledRequest))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JAXBContext jaxbContext = JAXBContext.newInstance(MessageC002.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            MessageC002 message = (MessageC002) jaxbUnmarshaller.unmarshal(new StringReader(response.body()));

            return CompletableFuture.completedFuture(message.getContents().getNomenclature().get(0).getEntry());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
