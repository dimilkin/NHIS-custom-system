package com.nzis.ignatovsoft.nhis.services;

import com.nzis.ignatovsoft.dtos.PatientDTO;
import com.nzis.ignatovsoft.nhis.services.mappers.InitialExamOpenerMarshaling;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class NetworkServiceImpl implements NetworkService {

    private final DigitalSignatureImpl digitalSignee = new DigitalSignatureImpl();
    private final InitialExamOpenerMarshaling initialExamOpenerMarshaling = new InitialExamOpenerMarshaling();

    @Override
    public String sendExaminationOpenRequest(PatientDTO patientDTO) {
        AuthenticationService authService = new AuthenticationService();

        try {
        String requestPayload = initialExamOpenerMarshaling.getMarshaledRequestBody(patientDTO);
        String signedRequest = digitalSignee.signXml(requestPayload);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://ptest-api.his.bg/v1/eexamination/examination/open"))
                .header("Content-Type", "application/xml")
                .header("Authorization", "Bearer " + authService.getAccessToken())
                .POST(HttpRequest.BodyPublishers.ofString(signedRequest))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (IOException | InterruptedException  e) {
            e.printStackTrace();
            return "";
        }
    }
}
