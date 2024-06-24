package com.nzis.ignatovsoft.nhis.services.mappers;

import com.nzis.ignatovsoft.configurations.application.DoctorInfo;
import com.nzis.ignatovsoft.dtos.ExamDTO;
import com.nzis.ignatovsoft.nhis.models.generated.*;
import com.nzis.ignatovsoft.nhis.models.nhis.x003.ContentsX003;
import com.nzis.ignatovsoft.nhis.models.nhis.x003.Examination;
import com.nzis.ignatovsoft.nhis.models.nhis.x003.MessageX003;
import com.nzis.ignatovsoft.nhis.models.nhis.x003.MotherHealthcare;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.StringWriter;
import java.util.Calendar;
import java.util.UUID;

import static com.nzis.ignatovsoft.nhis.services.HeadersGenerator.generateHeaders;

public class ExamClosingBodyX003Marshalling {

    public ExamClosingBodyX003Marshalling() {
    }

    public String getMarshalledRequestBody(ExamDTO examDTO) {
        try {
            return marshalRequestBody(examDTO);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private String marshalRequestBody(ExamDTO examDTO) throws JAXBException {
        ContentsX003 body = generateContents(examDTO);
        Header header = generateHeaders();
        MessageX003 messageX003 = new MessageX003();
        messageX003.setContents(body);
        messageX003.setHeader(header);

        JAXBContext context = JAXBContext.newInstance(MessageX003.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

        StringWriter sw = new StringWriter();
        marshaller.marshal(messageX003, sw);
        return sw.toString();
    }

    private ContentsX003 generateContents(ExamDTO examDTO) {
        DoctorInfo doctorInfo = new DoctorInfo();
        Examination examination = generateExamination(examDTO);

        ContentsX003 contentsX003 = new ContentsX003();
        contentsX003.setExamination(examination);

        return contentsX003;
    }

    private Examination generateExamination(ExamDTO examDTO) {
        Examination examination = new Examination();
        NrnBase nrnBase = new NrnBase();
        nrnBase.setValue(examDTO.getNrnExamination());
        examination.setNrnExamination(nrnBase);

        IsSecondaryBase isSecondaryBase = new IsSecondaryBase();
        isSecondaryBase.setValue(examDTO.isSecondaryField());
        examination.setIsSecondary(isSecondaryBase);

        CloseDateBase closeDateBase = new CloseDateBase();
        closeDateBase.setValue(Calendar.getInstance());
        examination.setCloseDate(closeDateBase);

        PurposeBase purposeBase = new PurposeBase();
        purposeBase.setValue(examDTO.getPurposeField());
        examination.setPurpose(purposeBase);

        IncidentalVisitBase incidentalVisitBase = new IncidentalVisitBase();
        incidentalVisitBase.setValue(false);
        examination.setIncidentalVisit(incidentalVisitBase);

        AdverseConditionsBase adverseConditionsBase = new AdverseConditionsBase();
        adverseConditionsBase.setValue(false);
        examination.setAdverseConditions(adverseConditionsBase);

        MotherHealthcare motherHealthcare = generateMotherHealthcare(examDTO);
        examination.setMotherHealthcare(motherHealthcare);

        DiagnosisFull diagnosisFull = generateDiagnosisFull(examDTO);
        examination.setDiagnosis(diagnosisFull);

        return examination;
    }

    private DiagnosisFull generateDiagnosisFull(ExamDTO examDTO) {
        DiagnosisFull diagnosisFull = new DiagnosisFull();

        MkbBase mkbBase = new MkbBase();
        mkbBase.setValue(examDTO.getICDCode());
        MkbBase additionalMkbBase = new MkbBase();
        additionalMkbBase.setValue(examDTO.getAdditionalIcdCode());
        diagnosisFull.setCode(mkbBase);

        DiagnosisUseBase diagnosisUseBase = new DiagnosisUseBase();
        diagnosisUseBase.setValue(examDTO.getDiagnosisUse());
        diagnosisFull.setUse(diagnosisUseBase);

        DiagnosisRankBase diagnosisRankBase = new DiagnosisRankBase();
        diagnosisRankBase.setValue(examDTO.getDiagnosisRank());
        diagnosisFull.setRank(diagnosisRankBase);

        DiagnosisClinicalStatusBase diagnosisClinicalStatusBase = new DiagnosisClinicalStatusBase();
        diagnosisClinicalStatusBase.setValue(examDTO.getClinicalStatus());
        diagnosisFull.setClinicalStatus(diagnosisClinicalStatusBase);

        DiagnosisVerificationStatusBase diagnosisVerificationStatusBase = new DiagnosisVerificationStatusBase();
        diagnosisVerificationStatusBase.setValue(examDTO.getVerificationStatus());
        diagnosisFull.setVerificationStatus(diagnosisVerificationStatusBase);

        DiagnosisOnsetBase diagnosisOnsetBase = new DiagnosisOnsetBase();
        diagnosisOnsetBase.setValue(Calendar.getInstance());
        diagnosisFull.setOnsetDateTime(diagnosisOnsetBase);

        return diagnosisFull;
    }

    private MotherHealthcare generateMotherHealthcare(ExamDTO examDTO) {
        MotherHealthcare motherHealthcare = new MotherHealthcare();
        IsPregnantBase isPregnantBase = new IsPregnantBase();
        isPregnantBase.setValue(examDTO.isPregnantField());
        motherHealthcare.setIsPregnant(isPregnantBase);

        IsBreastFeedingBase isBreastFeedingBase = new IsBreastFeedingBase();
        isBreastFeedingBase.setValue(examDTO.isBreastFeedingField());
        motherHealthcare.setIsBreastFeeding(isBreastFeedingBase);

        GestationalWeekBase gestationalWeekBase = new GestationalWeekBase();
        gestationalWeekBase.setValue(examDTO.getGestationalWeekField());
        motherHealthcare.setGestationalWeek(gestationalWeekBase);

        return motherHealthcare;
    }


    private String getRandomUUID () {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
