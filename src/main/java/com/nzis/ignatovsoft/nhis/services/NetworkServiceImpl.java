package com.nzis.ignatovsoft.nhis.services;

import com.nzis.ignatovsoft.nhis.models.generated.*;
import com.nzis.ignatovsoft.nhis.models.nhis.x001.ContentsX001;
import com.nzis.ignatovsoft.nhis.models.nhis.x001.Examination;
import com.nzis.ignatovsoft.nhis.models.nhis.x001.MessageX001;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Calendar;
import java.util.UUID;


public class NetworkServiceImpl implements NetworkService {

    private final DigitalSignatureImpl digitalSignee = new DigitalSignatureImpl();

    @Override
    public String sendExaminationOpenRequest(String authToken) {

        try {
        String requestPayload = marshalRequestBody();
        String signedRequest = digitalSignee.signXml(requestPayload);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://ptest-api.his.bg/v1/eexamination/examination/open"))
                .header("Content-Type", "application/xml")
                .header("Authorization", "Bearer " + authToken)
                .POST(HttpRequest.BodyPublishers.ofString(signedRequest))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (IOException | InterruptedException | DatatypeConfigurationException | JAXBException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String marshalRequestBody () throws DatatypeConfigurationException, JAXBException {
        ContentsX001 body = generateContents();
        Header header = generateHeaders();
        MessageX001 messageX001 = new MessageX001();
        messageX001.setContents(body);
        messageX001.setHeader(header);


        JAXBContext context = JAXBContext.newInstance(MessageX001.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

        StringWriter sw = new StringWriter();
        marshaller.marshal(messageX001, sw);
        return sw.toString();
    }

    private Header generateHeaders() {
        Header header = new Header();

        MessageSender sender = new MessageSender();
        sender.setValue("1");
        header.setSender(sender);

        MessageSenderId senderId = new MessageSenderId();
        senderId.setValue("2400000354");
        header.setSenderId(senderId);

        MessageSenderISName senderISName = new MessageSenderISName();
        senderISName.setValue("IgnatovSoft");
        header.setSenderISName(senderISName);

        MessageRecipient recipient = new MessageRecipient();
        recipient.setValue("4");
        header.setRecipient(recipient);

        MessageRecipientId recipientId = new MessageRecipientId();
        recipientId.setValue("NHIS");
        header.setRecipientId(recipientId);

        MessageId messageId = new MessageId();
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        messageId.setValue(uuidAsString);
        header.setMessageId(messageId);

        MessageType messageType = new MessageType();
        messageType.setValue("X001");
        header.setMessageType(messageType);

        MessageCreatedOn createdOn = new MessageCreatedOn();
        createdOn.setValue(Calendar.getInstance());
        header.setCreatedOn(createdOn);

        return header;
    }

    private ContentsX001 generateContents() throws DatatypeConfigurationException {
        Examination examination = generateExamination();
        MedicalPractitionerWithAccompanying performer = generatePerformer();
        Patient subject = generateSubject();

        ContentsX001 contentsX001 = new ContentsX001();
        contentsX001.setExamination(examination);
        contentsX001.setPerformer(performer);
        contentsX001.setSubject(subject);

        return contentsX001;
    }

    private Examination generateExamination(){
        Examination examination = new Examination();
        LrnBase lrnBase = new LrnBase();
        lrnBase.setValue("0897457c-3518-4760-852d-22d4acdd3ef7");
        examination.setLrn(lrnBase);

        ClassBase classBase = new ClassBase();
        classBase.setValue("1");
        examination.setClassBase(classBase);

        FinancingSourceBase financingSourceBase = new FinancingSourceBase();
        financingSourceBase.setValue("4");
        examination.setFinancingSource(financingSourceBase);

        OpenDateBase openDateBase = new OpenDateBase();
        openDateBase.setValue(Calendar.getInstance());
        examination.setOpenDate(openDateBase);

        RhifAreaNumberBase rhifAreaNumberBase = new RhifAreaNumberBase();
        rhifAreaNumberBase.setValue("2201");
        examination.setRhifAreaNumber(rhifAreaNumberBase);
        return examination;
    }

    private MedicalPractitionerWithAccompanying generatePerformer () {
        MedicalPractitionerWithAccompanying performer = new MedicalPractitionerWithAccompanying();

        EmailBase emailBase = new EmailBase();
        emailBase.setValue("test@test.abv.bg");
        performer.setEmail(emailBase);

        PhoneBase phoneBase = new PhoneBase();
        phoneBase.setValue("0888555666");
        performer.setPhone(phoneBase);

        performer.setNhifNumber(null);

        PmiBase pmiBase = new PmiBase();
        pmiBase.setValue("2400000354");
        performer.setPmi(pmiBase);

        QualificationBase qualificationBase = new QualificationBase();
        qualificationBase.setValue("1001");
        qualificationBase.setNhifCode(null);
        performer.setQualification(qualificationBase);

        performer.setPmiDeputy(null);

        PracticeNumberBase practiceNumberBase = new PracticeNumberBase();
        practiceNumberBase.setValue("2400000354");
        performer.setPracticeNumber(practiceNumberBase);

        performer.setRhifAreaNumber(null);

        DeputyRoleBase roleBase = new DeputyRoleBase();
        roleBase.setValue("1");
        performer.setRole(roleBase);

        return performer;
    }

    private Patient generateSubject () throws DatatypeConfigurationException {

        Patient patient = new Patient();

        IdentifierTypeBase identifierTypeBase = new IdentifierTypeBase();
        identifierTypeBase.setValue("1");
        patient.setIdentifierType(identifierTypeBase);

        IdentifierBase identifierBase = new IdentifierBase();
        identifierBase.setValue("9101127242");
        patient.setIdentifier(identifierBase);

        BirthDateBase birthDateBase = new BirthDateBase();
        String dateTimeString = "1991-01-12T17:05:45.678Z";
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTimeString);
        birthDateBase.setValue(date2);
        patient.setBirthDate(birthDateBase);

        GenderBase genderBase = new GenderBase();
        genderBase.setValue("1");
        patient.setGender(genderBase);

        HumanNameBase nameBase = new HumanNameBase();
        FamilyNameBase familyNameBase = new FamilyNameBase();
        familyNameBase.setValue("Милкин");
        nameBase.setFamily(familyNameBase);
        nameBase.setMiddle(null);
        GivenNameBase givenNameBase = new GivenNameBase();
        givenNameBase.setValue("Димитър");
        nameBase.setGiven(givenNameBase);
        patient.setName(nameBase);

        AddressBase addressBase = new AddressBase();
        CountryCodeBase countryCodeBase = new CountryCodeBase();
        countryCodeBase.setValue("BG");
        addressBase.setCountry(countryCodeBase);

        CountyBase countyBase = new CountyBase();
        countyBase.setValue("SOF");
        addressBase.setCounty(countyBase);

        CityBase cityBase = new CityBase();
        cityBase.setValue("Sofia");
        addressBase.setCity(cityBase);
        addressBase.setLine(null);
        addressBase.setPostalCode(null);
        addressBase.setEkatte(null);
        patient.setAddress(addressBase);

        patient.setNationality(null);
        patient.setPhone(null);
        patient.setEmail(null);

        return patient;
    }

    private String request() {
        return "<nhis:message xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:nhis=\"https://www.his.bg\" xsi:schemaLocation=\"https://www.his.bg https://www.his.bg/api/v1/NHIS-X001.xsd\">\n" +
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
