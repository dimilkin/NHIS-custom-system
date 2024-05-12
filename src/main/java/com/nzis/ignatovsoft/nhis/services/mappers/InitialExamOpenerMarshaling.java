package com.nzis.ignatovsoft.nhis.services.mappers;

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
import java.io.StringWriter;
import java.util.Calendar;
import java.util.UUID;

public class InitialExamOpenerMarshaling {

    public InitialExamOpenerMarshaling() {
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
        sender.setValue(HeadersInfoConstants.SENDER_TYPE);
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
        messageId.setValue(getRandomUUID());
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
        lrnBase.setValue(getRandomUUID());
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

    private String getRandomUUID () {
        UUID uuid = UUID.randomUUID();
       return uuid.toString();
    }
}
