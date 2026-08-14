package com.nzis.ignatovsoft.nhis.services.mappers;

import com.nzis.ignatovsoft.database.localdb.models.PracticeInfo;
import com.nzis.ignatovsoft.dataservices.SettingsDataService;
import com.nzis.ignatovsoft.dtos.PatientDTO;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.DateTimeValueBase;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.IntValueBase;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.MessageHeaderV3;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.StringValueBase;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.x001.*;
import com.nzis.ignatovsoft.nhis.services.HeadersGenerator;
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

    HeadersGenerator headersGenerator = new HeadersGenerator();

    public InitialExamOpenerMarshaling() {
    }

    public String getMarshaledRequestBody (PatientDTO patientDTO){
        try {
            return marshalRequestBody(patientDTO);
        } catch (DatatypeConfigurationException | JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private String marshalRequestBody (PatientDTO patientDTO) throws DatatypeConfigurationException, JAXBException {
        ContentsX001V3 body = generateContents(patientDTO);
        MessageHeaderV3 header = headersGenerator.generateHeadersV3(HeadersInfoConstants.MESSAGE_TYPE_X001);
        MessageX001V3 messageX001 = new MessageX001V3();
        messageX001.setContents(body);
        messageX001.setHeader(header);

        JAXBContext context = JAXBContext.newInstance(MessageX001V3.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

        StringWriter sw = new StringWriter();
        marshaller.marshal(messageX001, sw);
        return sw.toString();
    }

    private ContentsX001V3 generateContents(PatientDTO patientDTO) throws DatatypeConfigurationException {
        ExaminationX001V3 examination = generateExamination();
        PerformerV3 performer = generatePerformer();
        SubjectV3 subject = generateSubject(patientDTO);

        ContentsX001V3 contentsX001 = new ContentsX001V3();
        contentsX001.setExamination(examination);
        contentsX001.setPerformer(performer);
        contentsX001.setSubject(subject);

        return contentsX001;
    }

    private ExaminationX001V3 generateExamination(){
        ExaminationX001V3 examination = new ExaminationX001V3();

        examination.setLrn(new StringValueBase(getRandomUUID()));
        examination.setClassBase(new StringValueBase("1"));
        examination.setFinancingSource(new StringValueBase("4"));
        examination.setOpenDate(new DateTimeValueBase(Calendar.getInstance()));
        examination.setRhifAreaNumber(new StringValueBase("2201"));

        return examination;
    }

    private PerformerV3 generatePerformer () {
        PerformerV3 performer = new PerformerV3();

        SettingsDataService settingsDataService = new SettingsDataService();
        PracticeInfo practiceInfo  = settingsDataService.getSettings();

        performer.setEmail(new StringValueBase("test@test.abv.bg"));
        performer.setPhone(new StringValueBase("0888555666"));
        performer.setPmi(new StringValueBase(practiceInfo.getDoctorId()));

        QualificationV3 qualification = new QualificationV3();
        qualification.setValue(practiceInfo.getDoctorsQualification());
        qualification.setNhifCode(null);
        performer.setQualification(qualification);

        performer.setPracticeNumber(new StringValueBase(practiceInfo.getDoctorId()));
        performer.setRole(new StringValueBase("1"));

        return performer;
    }

    private SubjectV3 generateSubject (PatientDTO patientDTO) throws DatatypeConfigurationException {

        SubjectV3 subject = new SubjectV3();

        subject.setIdentifierType(new IntValueBase(Integer.parseInt(patientDTO.getIdentifierType())));
        subject.setIdentifier(new StringValueBase(patientDTO.getIdentifierValue()));

        XMLGregorianCalendar birthDateXml = DatatypeFactory.newInstance().newXMLGregorianCalendar(patientDTO.getBirthDay());
        subject.setBirthDate(new DateTimeValueBase(birthDateXml.toGregorianCalendar()));

        subject.setGender(new IntValueBase(Integer.parseInt(patientDTO.getGender())));

        MessageNameV3 name = new MessageNameV3();
        name.setFamily(new StringValueBase(patientDTO.getLastname()));
        name.setMiddle(null);
        name.setGiven(new StringValueBase(patientDTO.getFirstName()));
        subject.setName(name);

        // v3 dropped the address block from the subject; nationality is now
        // required instead and is backed by the same CL005 nomenclature as
        // addressCountry was, so we reuse it here.
        subject.setNationality(new StringValueBase(patientDTO.getAddressCountry()));

        return subject;
    }

    private String getRandomUUID () {
        UUID uuid = UUID.randomUUID();
       return uuid.toString();
    }
}
