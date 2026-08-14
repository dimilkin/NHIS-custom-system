package com.nzis.ignatovsoft.nhis.services.mappers;

import com.nzis.ignatovsoft.dtos.ExamDTO;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.BooleanValueBase;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.DateTimeValueBase;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.IntValueBase;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.MessageHeaderV3;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.StringValueBase;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.x003.*;
import com.nzis.ignatovsoft.nhis.services.HeadersGenerator;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.StringWriter;
import java.util.Calendar;


public class ExamClosingBodyX003Marshalling {

    private HeadersGenerator headersGenerator = new HeadersGenerator();

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
        ContentsX003V3 body = generateContents(examDTO);
        MessageHeaderV3 header = headersGenerator.generateHeadersV3(HeadersInfoConstants.MESSAGE_TYPE_X003);
        MessageX003V3 messageX003 = new MessageX003V3();
        messageX003.setContents(body);
        messageX003.setHeader(header);

        JAXBContext context = JAXBContext.newInstance(MessageX003V3.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

        StringWriter sw = new StringWriter();
        marshaller.marshal(messageX003, sw);
        return sw.toString();
    }

    private ContentsX003V3 generateContents(ExamDTO examDTO) {
        ExaminationX003V3 examination = generateExamination(examDTO);
        ContentsX003V3 contentsX003 = new ContentsX003V3();
        contentsX003.setExamination(examination);

        return contentsX003;
    }

    private ExaminationX003V3 generateExamination(ExamDTO examDTO) {
        ExaminationX003V3 examination = new ExaminationX003V3();

        examination.setNrnExamination(new StringValueBase(examDTO.getNrnExamination()));
        examination.setDirectedBy(new StringValueBase("2"));
        examination.setIsSecondary(new BooleanValueBase(examDTO.isSecondaryField()));
        examination.setCloseDate(new DateTimeValueBase(Calendar.getInstance()));
        examination.setPurpose(new StringValueBase(examDTO.getPurposeField()));
        examination.setIncidentalVisit(new BooleanValueBase(false));
        examination.setAdverseConditions(new BooleanValueBase(false));
        examination.setDiagnosis(generateDiagnosis(examDTO));
        examination.setMedicalHistory(generateMedicalHistory(examDTO));
        examination.setObjectiveCondition(generateObjectiveCondition(examDTO));

        return examination;
    }

    private DiagnosisV3 generateDiagnosis(ExamDTO examDTO) {
        DiagnosisV3 diagnosis = new DiagnosisV3();

        diagnosis.setCode(new StringValueBase(examDTO.getICDCode()));
        diagnosis.setUse(new StringValueBase(examDTO.getDiagnosisUse()));
        diagnosis.setRank(new IntValueBase(examDTO.getDiagnosisRank().intValue()));
        diagnosis.setClinicalStatus(new StringValueBase(examDTO.getClinicalStatus()));
        diagnosis.setVerificationStatus(new StringValueBase(examDTO.getVerificationStatus()));
        diagnosis.setOnsetDateTime(new DateTimeValueBase(Calendar.getInstance()));

        return diagnosis;
    }

    private MedicalHistoryV3 generateMedicalHistory(ExamDTO examDTO) {
        MedicalHistoryV3 medicalHistory = new MedicalHistoryV3();
        medicalHistory.setNote(new StringValueBase(examDTO.getNotes()));
        return medicalHistory;
    }

    private ObjectiveConditionV3 generateObjectiveCondition(ExamDTO examDTO) {
        ObjectiveConditionV3 objectiveCondition = new ObjectiveConditionV3();

        objectiveCondition.setIsPregnant(new BooleanValueBase(examDTO.isPregnantField()));
        objectiveCondition.setIsBreastFeeding(new BooleanValueBase(examDTO.isBreastFeedingField()));
        if (examDTO.getGestationalWeekField() != null) {
            objectiveCondition.setGestationalWeek(new IntValueBase(examDTO.getGestationalWeekField().intValue()));
        }
        objectiveCondition.setNote(new StringValueBase(examDTO.getNotes()));

        return objectiveCondition;
    }
}
