package com.nzis.ignatovsoft.nhis.services.mappers;

import com.nzis.ignatovsoft.dtos.ExamDTO;
import com.nzis.ignatovsoft.nhis.models.generated.*;
import com.nzis.ignatovsoft.nhis.models.nhis.x003.*;
import com.nzis.ignatovsoft.nhis.services.HeadersGenerator;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;


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
        ContentsX003 body = generateContents(examDTO);
        Header header = headersGenerator.generateHeaders(HeadersInfoConstants.MESSAGE_TYPE_X003);
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

        examination.setBasedOn(null);

        DirectedByBase directedBy = new DirectedByBase();
        directedBy.setValue("2");
        examination.setDirectedBy(directedBy);

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

//        examination.setChildHealthcare(null);

//        ConsultationBasic consultationBasic = generateConsultationBasic();
        examination.setConsultation(null);

//        List<Documents> documents = generateDocuments();
        examination.setDocuments(null);

        DiagnosisFull diagnosisFull = generateDiagnosisFull(examDTO);
        examination.setDiagnosis(diagnosisFull);

//        DiagnosisFull comorbidity = generateComorbidity();
        examination.setComorbidity(null);

        Text4KBase medicalHistory = new Text4KBase();
        medicalHistory.setValue("Test medical history");
        examination.setMedicalHistory(medicalHistory);

        Text4KBase objectiveCondition = new Text4KBase();
        objectiveCondition.setValue("Test objective condition");
        examination.setObjectiveCondition(objectiveCondition);

//        Assessment assessment = generateAssessment();
        examination.setAssessment(null);

//        DiagnosticReport diagnosticReport = generateDiagnosticReport();
        examination.setDiagnosticReport(null);

//        Therapy therapy = generateTherapy();
        examination.setTherapy(null);

        examination.setDischargeDisposition(null);

        examination.setConclusion(null);

        return examination;
    }

    private Therapy generateTherapy() {
      Therapy therapy = new Therapy();

        List<NrnBase> nrnPrescriptions = new ArrayList<>();
        NrnBase nrnBase = new NrnBase();
        nrnBase.setValue("");
        nrnPrescriptions.add(nrnBase);
        therapy.getNrnPrescriptions().addAll(nrnPrescriptions);

        List<MedicationCodeBase> medicationCodes = new ArrayList<>();
        MedicationCodeBase medicationCodeBase = new MedicationCodeBase();
        medicationCodeBase.setValue("");
        medicationCodes.add(medicationCodeBase);
        therapy.getMedicationCodes().addAll(medicationCodes);

        Text4KBase note = new Text4KBase();
        note.setValue("");
        therapy.setNote(note);

        return therapy;
    }

    private DiagnosticReport generateDiagnosticReport() {
        DiagnosticReport diagnosticReport = new DiagnosticReport();

        SpecializedActivityCodeBase code = new SpecializedActivityCodeBase();
        code.setValue(null);
        diagnosticReport.setCode(code);

        MdaStatus status = new MdaStatus();
        status.setValue(null);
        diagnosticReport.setStatus(status);

        NumberPerformedBase numberPerformed = new NumberPerformedBase();
        numberPerformed.setValue(null);
        diagnosticReport.setNumberPerformed(numberPerformed);

        Text8KBase conclusion = new Text8KBase();
        conclusion.setValue(null);
        diagnosticReport.setConclusion(conclusion);

        return diagnosticReport;

        //Lists Missing
    }

    private Assessment generateAssessment() {
        Assessment assessment = new Assessment();
        assessment.setDirectedOn(null);
        assessment.setPerformedOn(null);
        assessment.setNote(null);
        return assessment;
        //Lists Missing
    }

    private DiagnosisFull generateComorbidity() {
        DiagnosisFull diagnosisFull = new DiagnosisFull();

        MkbBase mkbBase = new MkbBase();
        mkbBase.setValue(null);
        diagnosisFull.setCode(mkbBase);

        DiagnosisUseBase diagnosisUseBase = new DiagnosisUseBase();
        diagnosisUseBase.setValue(null);
        diagnosisFull.setUse(diagnosisUseBase);

        DiagnosisRankBase diagnosisRankBase = new DiagnosisRankBase();
        diagnosisRankBase.setValue(null);
        diagnosisFull.setRank(diagnosisRankBase);

        DiagnosisClinicalStatusBase diagnosisClinicalStatusBase = new DiagnosisClinicalStatusBase();
        diagnosisClinicalStatusBase.setValue(null);
        diagnosisFull.setClinicalStatus(diagnosisClinicalStatusBase);

        DiagnosisVerificationStatusBase diagnosisVerificationStatusBase = new DiagnosisVerificationStatusBase();
        diagnosisVerificationStatusBase.setValue(null);
        diagnosisFull.setVerificationStatus(diagnosisVerificationStatusBase);

        DiagnosisOnsetBase diagnosisOnsetBase = new DiagnosisOnsetBase();
        diagnosisOnsetBase.setValue(null);
        diagnosisFull.setOnsetDateTime(diagnosisOnsetBase);

        Text4KBase note = new Text4KBase();
        note.setValue(null);
        diagnosisFull.setNote(note);

        return diagnosisFull;
    }

    private List<Documents> generateDocuments() {

        List<Documents> documents = new ArrayList<>();

//        Documents documents1 = new Documents();
//
//        NrnBase nrnBase = new NrnBase();
//        nrnBase.setValue(null);
//        documents1.setNrnReferral(nrnBase);
//
//        NrnBase nrnPerscription = new NrnBase();
//        nrnPerscription.setValue(null);
//        documents1.setNrnPrescription(nrnPerscription);
//
//        NrnBase nrnImmunization = new NrnBase();
//        nrnImmunization.setValue(null);
//        documents1.setNrnImmunization(nrnImmunization);
//
//        IssuedDocumentBase issuedTelkDocument = new IssuedDocumentBase();
//        issuedTelkDocument.setValue(false);
//        issuedTelkDocument.setDataType(null);
//        documents1.setIssuedTelkDocument(issuedTelkDocument);
//
//        IssuedDocumentBase issuedInterim = new IssuedDocumentBase();
//        issuedTelkDocument.setValue(false);
//        issuedTelkDocument.setDataType(null);
//        documents1.setIssuedInterimReport(issuedInterim);
//
//        IssuedDocumentBase issuedMedical = new IssuedDocumentBase();
//        issuedTelkDocument.setValue(false);
//        issuedTelkDocument.setDataType(null);
//        documents1.setIssuedMedicalNotice(issuedMedical);
//
//        IssuedDocumentBase quickNotice = new IssuedDocumentBase();
//        issuedTelkDocument.setValue(false);
//        issuedTelkDocument.setDataType(null);
//        documents1.setIssuedQuickNotice(quickNotice);
//
//        documents.add(documents1);
        return documents;
    }

    private ConsultationBasic generateConsultationBasic() {

        ConsultationBasic consultationBasic = new ConsultationBasic();
        NrnBase nrnConsultation = new NrnBase();
        nrnConsultation.setValue(null);
        consultationBasic.setNrnConsultation(nrnConsultation);

        TimestampBase directedOn = new TimestampBase();
        directedOn.setValue(Calendar.getInstance());
        consultationBasic.setDirectedOn(directedOn);

        QualificationBase qualification = new QualificationBase();
        qualification.setValue(null);
        consultationBasic.setQualification(qualification);

        TimestampBase performedOn = new TimestampBase();
        performedOn.setValue(Calendar.getInstance());
        consultationBasic.setPerformedOn(performedOn);

        Text4KBase note = new Text4KBase();
        note.setValue(null);
        consultationBasic.setNote(note);

        return consultationBasic;
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
        diagnosisClinicalStatusBase.setValue(null);
        diagnosisFull.setClinicalStatus(diagnosisClinicalStatusBase);

        DiagnosisVerificationStatusBase diagnosisVerificationStatusBase = new DiagnosisVerificationStatusBase();
        diagnosisVerificationStatusBase.setValue(null);
        diagnosisFull.setVerificationStatus(diagnosisVerificationStatusBase);

        DiagnosisOnsetBase diagnosisOnsetBase = new DiagnosisOnsetBase();
        diagnosisOnsetBase.setValue(Calendar.getInstance());
        diagnosisFull.setOnsetDateTime(diagnosisOnsetBase);

        diagnosisFull.setNote(null);

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


    private String getRandomUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
