package com.nzis.ignatovsoft.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import static com.nzis.ignatovsoft.Constants.MAIN_PATH;
import static com.nzis.ignatovsoft.Constants.OPEN_EXAMINATION_PATH;


public class NetworkServiceImpl implements NetworkService {

    private DigitalSigneeImpl digitalSignee = new DigitalSigneeImpl();
    @Override
    public String sendExaminationOpenRequest(String authToken) {

        String requestPayload = request();
        String signedRequest = digitalSignee.signXml(requestPayload);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://ptest-api.his.bg/v1/eexamination/examination/open"))
                .header("Content-Type", "application/xml")
                .header("Authorization", "Bearer " + authToken)
                .POST(HttpRequest.BodyPublishers.ofString(signedRequest))
                .build();


        try {
            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );
            String responseBody = response.body();
            return responseBody;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }
    }


    private String request () {
        return  "<nhis:message xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:nhis=\"https://www.his.bg\" xsi:schemaLocation=\"https://www.his.bg https://www.his.bg/api/v1/NHIS-X001.xsd\">\n" +
                "    <nhis:header>\n" +
                "        <nhis:sender value=\"1\"/>\n" +
                "        <nhis:senderId value=\"220010652\"/>\n" +
                "        <nhis:senderISName value=\"IgnatovSoft\"/>\n" +
                "        <nhis:recipient value=\"4\"/>\n" +
                "        <nhis:recipientId value=\"NHIS\"/>\n" +
                "        <nhis:messageId value=\"c80c6c30-432d-4d3b-9e1e-53168b1feae2\"/>\n" +
                "        <nhis:messageType value=\"X001\"/>\n" +
                "        <nhis:createdOn value=\"2023-12-352T04:28:53Z\"/>\n" +
                "    </nhis:header>\n" +
                "    <nhis:contents>\n" +
                "        <nhis:examination>\n" +
                "            <nhis:lrn value=\"0897457c-3518-4760-852d-22d4acdd3ef7\"/>\n" +
                "            <nhis:openDate value=\"2023-12-352T04:28:53Z\"/>\n" +
                "            <nhis:class value=\"1\"/>\n" +
                "            <nhis:financingSource value=\"4\"/>\n" +
                "            <nhis:rhifAreaNumber value=\"2201\"/>\n" +
                "        </nhis:examination>\n" +
                "        <nhis:subject>\n" +
                "            <nhis:identifierType value=\"1\"/>\n" +
                "            <nhis:identifier value=\"9101127242\"/>\n" +
                "            <nhis:birthDate value=\"1991-12-01\"/>\n" +
                "            <nhis:gender value=\"1\"/>\n" +
                "            <nhis:name>\n" +
                "                <nhis:given value=\"Dimitar\"/>\n" +
                "                <nhis:family value=\"Milkin\"/>\n" +
                "            </nhis:name>\n" +
                "            <nhis:address>\n" +
                "                <nhis:country value=\"BG\"/>\n" +
                "                <nhis:county value=\"SOF\"/>\n" +
                "                <nhis:city value=\"Sofia\"/>\n" +
                "                <nhis:line value=\"Drujba II\"/>\n" +
                "                <nhis:postalCode value=\"1000\"/>\n" +
                "            </nhis:address>\n" +
                "            <nhis:nationality value=\"BG\"/>\n" +
                "            <nhis:phone value=\"0888555444\"/>\n" +
                "            <nhis:email value=\"test@test.com\"/>\n" +
                "        </nhis:subject>\n" +
                "        <nhis:performer>\n" +
                "            <nhis:pmi value=\"220010652\"/>\n" +
                "            <nhis:pmiDeputy value=\"null\"/>\n" +
                "            <nhis:qualification value=\"1001\"/>\n" +
                "            <nhis:practiceNumber value=\"220010652\"/>\n" +
                "            <nhis:role value=\"1\"/>\n" +
                "            <nhis:accompanying>\n" +
                "                <nhis:pmi value=\"null\"/>\n" +
                "                <nhis:qualification value=\"null\"/>\n" +
                "            </nhis:accompanying>\n" +
                "            <nhis:phone value=\"0888545454\"/>\n" +
                "            <nhis:email value=\"test@test2.com\"/>\n" +
                "            <nhis:rhifAreaNumber value=\"null\"/>\n" +
                "            <nhis:nhifNumber value=\"null\"/>\n" +
                "        </nhis:performer>\n" +
                "    </nhis:contents>\n" +
                "</nhis:message>";
    }


}
