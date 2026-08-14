package com.nzis.ignatovsoft.nhis.services;

import com.nzis.ignatovsoft.dtos.ExamDTO;
import com.nzis.ignatovsoft.dtos.PatientDTO;
import com.nzis.ignatovsoft.exceptions.NHISErrorException;
import com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002.Entry;
import com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002.MessageC002;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.r099.MessageR099;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.x002.ContentsX002V2;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.x002.MessageX002V2;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.x004.MessageX004V2;
import com.nzis.ignatovsoft.nhis.models.nhis.x099.MessageX099;
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
    public ContentsX002V2 sendExaminationOpenRequestX001(PatientDTO patientDTO) throws NHISErrorException {
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

            JAXBContext jaxbContext;
            Unmarshaller jaxbUnmarshaller;

            switch (response.statusCode()) {
                case 200:
                    jaxbContext = JAXBContext.newInstance(MessageX002V2.class);
                    jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                    MessageX002V2 message = (MessageX002V2) jaxbUnmarshaller.unmarshal(new StringReader(response.body()));
                    return message.getContents();
                default:
                    jaxbContext = JAXBContext.newInstance(MessageR099.class);
                    jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                    MessageR099 errorMessage = (MessageR099) jaxbUnmarshaller.unmarshal(new StringReader(response.body()));
                    throw new NHISErrorException(errorMessage.getContents().get(0).getReason().getValue());
            }
        } catch (IOException | InterruptedException | JAXBException e) {
            e.printStackTrace();
            return null;
        } catch (NHISErrorException e) {
            throw new NHISErrorException(e.getMessage());
        }
    }

    @Override
    public int sendExaminationCloseRequestX003(ExamDTO examDTO) throws NHISErrorException {
        ExamClosingBodyX003Marshalling examClosingBodyX003Marshalling = new ExamClosingBodyX003Marshalling();

        try {
            String marshaledRequest = examClosingBodyX003Marshalling.getMarshalledRequestBody(examDTO);
            String signedRequest = digitalSignee.signXml(marshaledRequest);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://ptest-api.his.bg/v3/eexamination/examination/close"))
                    .header("Content-Type", "application/xml")
                    .header("Authorization", "Bearer " + authService.getAccessToken())
                    .POST(HttpRequest.BodyPublishers.ofString(signedRequest))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            switch (response.statusCode()) {
                case 200:
                    JAXBContext jaxbContext = JAXBContext.newInstance(MessageX004V2.class);
                    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                    jaxbUnmarshaller.unmarshal(new StringReader(response.body()));
                    return 200;
                default:
                    JAXBContext errorContext = JAXBContext.newInstance(MessageR099.class);
                    Unmarshaller errorUnmarshaller = errorContext.createUnmarshaller();
                    MessageR099 errorMessage = (MessageR099) errorUnmarshaller.unmarshal(new StringReader(response.body()));
                    throw new NHISErrorException(errorMessage.getContents().get(0).getReason().getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new NHISErrorException(e.getMessage());
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

            JAXBContext jaxbContext;
            Unmarshaller jaxbUnmarshaller;
            switch (response.statusCode()) {
                case 200:
                    jaxbContext = JAXBContext.newInstance(MessageC002.class);
                    jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                    MessageC002 message = (MessageC002) jaxbUnmarshaller.unmarshal(new StringReader(response.body()));
                    return CompletableFuture.completedFuture(message.getContents().getNomenclature().get(0).getEntry());
                default:
                    jaxbContext = JAXBContext.newInstance(MessageX099.class);
                    jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                    MessageX099 errorMessage = (MessageX099) jaxbUnmarshaller.unmarshal(new StringReader(response.body()));
                    return CompletableFuture.failedFuture(new NHISErrorException(errorMessage.getContents().getError().get(0).getReason().getValue()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
