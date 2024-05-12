package com.nzis.ignatovsoft.nhis.services;


import com.nzis.ignatovsoft.nhis.models.nhis.auth.MessageS001;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.nzis.ignatovsoft.Constants.AUTH_PATH_TOKEN;

public class AuthenticationService {
    private final DigitalSignatureImpl digitalSignee;
    private String token = "";


    public AuthenticationService() {
        this.digitalSignee = new DigitalSignatureImpl();
    }

    public String getAccessToken() {
        if (token.isEmpty()) {
            String signedChalange = "";
            String chalange = getChalange(AUTH_PATH_TOKEN);
            signedChalange = digitalSignee.signXml(chalange);
            token = getAuthToken(AUTH_PATH_TOKEN, signedChalange);
        }
        return token;
    }

    private String getChalange(String authPath) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(authPath))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String getAuthToken(String authPath, String signedChalange) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(authPath))
                .header("Content-Type", "application/xml")
                .POST(HttpRequest.BodyPublishers.ofString(signedChalange))
                .build();

        try {
            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            JAXBContext jaxbContext = JAXBContext.newInstance(MessageS001.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            MessageS001 message = (MessageS001) jaxbUnmarshaller.unmarshal(new StringReader(response.body()));
            return message.getContents().getAccessToken().getValue();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
