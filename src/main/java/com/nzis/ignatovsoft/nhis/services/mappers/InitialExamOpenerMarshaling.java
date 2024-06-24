package com.nzis.ignatovsoft.nhis.services.mappers;

import com.nzis.ignatovsoft.configurations.application.DoctorInfo;
import com.nzis.ignatovsoft.dtos.PatientDTO;
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

import static com.nzis.ignatovsoft.nhis.services.HeadersGenerator.generateHeaders;

public class InitialExamOpenerMarshaling {

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
        ContentsX001 body = generateContents(patientDTO
        );
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

    private ContentsX001 generateContents(PatientDTO patientDTO) throws DatatypeConfigurationException {
        Examination examination = generateExamination();
        DoctorInfo doctorInfo = new DoctorInfo();
        MedicalPractitionerWithAccompanying performer = generatePerformer(doctorInfo);
        Patient subject = generateSubject(patientDTO);

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

    private MedicalPractitionerWithAccompanying generatePerformer (DoctorInfo doctorInfo) {
        MedicalPractitionerWithAccompanying performer = new MedicalPractitionerWithAccompanying();

        EmailBase emailBase = new EmailBase();
        emailBase.setValue("test@test.abv.bg");
        performer.setEmail(emailBase);

        PhoneBase phoneBase = new PhoneBase();
        phoneBase.setValue("0888555666");
        performer.setPhone(phoneBase);

        performer.setNhifNumber(null);

        PmiBase pmiBase = new PmiBase();
        pmiBase.setValue(doctorInfo.getDoctorsId());
        performer.setPmi(pmiBase);

        QualificationBase qualificationBase = new QualificationBase();
        qualificationBase.setValue("1001");
        qualificationBase.setNhifCode(null);
        performer.setQualification(qualificationBase);

        performer.setPmiDeputy(null);

        PracticeNumberBase practiceNumberBase = new PracticeNumberBase();
        practiceNumberBase.setValue(doctorInfo.getDoctorsId());
        performer.setPracticeNumber(practiceNumberBase);

        performer.setRhifAreaNumber(null);

        DeputyRoleBase roleBase = new DeputyRoleBase();
        roleBase.setValue("1");
        performer.setRole(roleBase);

        return performer;
    }

    private Patient generateSubject (PatientDTO patientDTO) throws DatatypeConfigurationException {

        Patient patient = new Patient();

        IdentifierTypeBase identifierTypeBase = new IdentifierTypeBase();
        identifierTypeBase.setValue(patientDTO.getIdentifierType());
        patient.setIdentifierType(identifierTypeBase);

        IdentifierBase identifierBase = new IdentifierBase();
        identifierBase.setValue(patientDTO.getIdentifierValue());
        patient.setIdentifier(identifierBase);

        BirthDateBase birthDateBase = new BirthDateBase();
        String dateTimeString = patientDTO.getBirthDay(); //"1991-01-12T17:05:45.678Z";
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTimeString);
        birthDateBase.setValue(date2);
        patient.setBirthDate(birthDateBase);

        GenderBase genderBase = new GenderBase();
        genderBase.setValue(patientDTO.getGender());
        patient.setGender(genderBase);

        HumanNameBase nameBase = new HumanNameBase();
        FamilyNameBase familyNameBase = new FamilyNameBase();
        familyNameBase.setValue(patientDTO.getLastname());
        nameBase.setFamily(familyNameBase);
        nameBase.setMiddle(null);
        GivenNameBase givenNameBase = new GivenNameBase();
        givenNameBase.setValue(patientDTO.getFirstName());
        nameBase.setGiven(givenNameBase);
        patient.setName(nameBase);

        AddressBase addressBase = new AddressBase();
        CountryCodeBase countryCodeBase = new CountryCodeBase();
        countryCodeBase.setValue(patientDTO.getAddressCountry());
        addressBase.setCountry(countryCodeBase);

        CountyBase countyBase = new CountyBase();
        countyBase.setValue(patientDTO.getAddressCounty());
        addressBase.setCounty(countyBase);

        CityBase cityBase = new CityBase();
        cityBase.setValue(patientDTO.getAddressCity());
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
