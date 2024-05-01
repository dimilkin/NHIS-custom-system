package com.nzis.ignatovsoft.services;

import com.nzis.ignatovsoft.models.generated.https.www_his.ContentsS001;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.nzis.ignatovsoft.Constants.AUTH_PATH_TOKEN;

public class AuthenticationService {
    private DigitalSigneeImpl digitalSignee;
    private String token = "";
    String correctAuthResponse = "";

    public AuthenticationService() {
        this.digitalSignee = new DigitalSigneeImpl();
    }

    public String getAccessToken() {
        String signedChalange = "";

        if (correctAuthResponse.isEmpty()) {
            String chalange = getChalange(AUTH_PATH_TOKEN);
            signedChalange = digitalSignee.signXml(chalange);
        }
        token = authenticate(signedChalange, AUTH_PATH_TOKEN);

        return token;
    }

    private String authenticate(String signedChalange, String authPath) {

        if (correctAuthResponse.isEmpty()) {
            correctAuthResponse = getCorrectAuthResponse(authPath, signedChalange);
        }

        try {
            InputStream targetStream = new ByteArrayInputStream(correctAuthResponse.getBytes());

            JAXBContext jaxbContext = JAXBContext.newInstance(ContentsS001.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ContentsS001 responseContents = (ContentsS001) jaxbUnmarshaller.unmarshal(targetStream);

            String token = responseContents.getAccessToken().getValue();
            return token;
        } catch (JAXBException| NullPointerException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String getChalange(String authPath) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(authPath))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();
            return responseBody;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String getCorrectAuthResponse(String authPath, String signedChalange) {
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
            return response.body();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String signer() {
        return "\"<Signature xmlns=\\\"http://www.w3.org/2000/09/xmldsig#\\\">\"\n" +
                "            \"<SignedInfo>\"\n" +
                "                \"<CanonicalizationMethod Algorithm=\\\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\\\" />\"\n" +
                "                \"<SignatureMethod Algorithm=\\\"http://www.w3.org/2001/04/xmldsig-more#rsa-sha256\\\" />\"\n" +
                "                \"<Reference URI=\\\"\\\">\"\n" +
                "                    \"<Transforms>\"\n" +
                "                        \"<Transform Algorithm=\\\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\\\" />\"\n" +
                "                    \"</Transforms>\"\n" +
                "                    \"<DigestMethod Algorithm=\\\"http://www.w3.org/2001/04/xmlenc#sha256\\\" />\"\n" +
                "                        \"<DigestValue></DigestValue>\"\n" +
                "                \"</Reference>\"\n" +
                "            \"</SignedInfo>\"\n" +
                "            \"<SignatureValue></SignatureValue>\"\n" +
                "            \"<KeyInfo>\"\n" +
                "                \"<X509Data>\"\n" +
                "                    \"<X509Certificate></X509Certificate>\"\n" +
                "                \"</X509Data>\"\n" +
                "            \"</KeyInfo>\"\n" +
                "        \"</Signature>\"\n";
    }

    private String signer2() {
        return "<Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\">\n" +
                "        <SignedInfo>\n" +
                "            <CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/>\n" +
                "            <SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/>\n" +  //tuk
                "            <Reference URI=\"\">\n" +
                "                <Transforms>\n" +
                "                    <Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/>\n" +
                "                </Transforms>\n" +
                "                <DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\"/>\n" +
                "                <DigestValue></DigestValue>\n" +
                "            </Reference>\n" +
                "        </SignedInfo>\n" +
                "        <SignatureValue></SignatureValue>\n" +
                "        <KeyInfo>\n" +
                "            <X509Data>\n" +
                "                <X509Certificate></X509Certificate>\n" +
                "            </X509Data>\n" +
                "        </KeyInfo>\n" +
                "    </Signature>";
    }
}
