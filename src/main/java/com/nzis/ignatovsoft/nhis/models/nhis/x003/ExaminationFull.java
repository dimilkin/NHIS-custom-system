package com.nzis.ignatovsoft.nhis.models.nhis.x003;

import com.nzis.ignatovsoft.nhis.models.generated.*;
import jakarta.xml.bind.annotation.XmlType;

//@XmlRootElement(name = "examination")
@XmlType(propOrder = { "nrnExamination", "basedOn", "directedBy", "isSecondary", "closeDate", "purpose",
        "incidentalVisit", "adverseConditions", "motherHealthcare", "childHealthcare", "consultation", "documents",
        "diagnosis", "comorbidity", "medicalHistory", "objectiveCondition", "assessment", "diagnosticReport", "conclusion", "dischargeDisposition", "therapy" })
public class ExaminationFull {

    private NrnBase nrnExamination;
    private DocumentNumberBase basedOn;
    private DirectedByBase directedBy;
    private IsSecondaryBase isSecondary;
    private CloseDateBase closeDate;
    private PurposeBase purpose;
    private IncidentalVisitBase incidentalVisit;
    private AdverseConditionsBase adverseConditions;
    private MotherHealthcare motherHealthcare;
    private ChildHealthcare childHealthcare;
    private ConsultationBasic consultation;
    private Documents documents;
    private DiagnosisFull diagnosis;
    private DiagnosisFull comorbidity;
    private Text4kBase medicalHistory;
    private Text4kBase objectiveCondition;
    private Assessment assessment;
    private DiagnosticReport diagnosticReport;
    private ConclusionBase conclusion;
    private DischargeDispositionBase dischargeDisposition;
    private Therapy therapy;

    public NrnBase getNrnExamination() {
        return nrnExamination;
    }

    public void setNrnExamination(NrnBase nrnExamination) {
        this.nrnExamination = nrnExamination;
    }

    public DocumentNumberBase getBasedOn() {
        return basedOn;
    }

    public void setBasedOn(DocumentNumberBase basedOn) {
        this.basedOn = basedOn;
    }

    public DirectedByBase getDirectedBy() {
        return directedBy;
    }

    public void setDirectedBy(DirectedByBase directedBy) {
        this.directedBy = directedBy;
    }

    public IsSecondaryBase getIsSecondary() {
        return isSecondary;
    }

    public void setIsSecondary(IsSecondaryBase isSecondary) {
        this.isSecondary = isSecondary;
    }

    public CloseDateBase getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(CloseDateBase closeDate) {
        this.closeDate = closeDate;
    }

    public PurposeBase getPurpose() {
        return purpose;
    }

    public void setPurpose(PurposeBase purpose) {
        this.purpose = purpose;
    }

    public IncidentalVisitBase getIncidentalVisit() {
        return incidentalVisit;
    }

    public void setIncidentalVisit(IncidentalVisitBase incidentalVisit) {
        this.incidentalVisit = incidentalVisit;
    }

    public AdverseConditionsBase getAdverseConditions() {
        return adverseConditions;
    }

    public void setAdverseConditions(AdverseConditionsBase adverseConditions) {
        this.adverseConditions = adverseConditions;
    }

    public MotherHealthcare getMotherHealthcare() {
        return motherHealthcare;
    }

    public void setMotherHealthcare(MotherHealthcare motherHealthcare) {
        this.motherHealthcare = motherHealthcare;
    }

    public ChildHealthcare getChildHealthcare() {
        return childHealthcare;
    }

    public void setChildHealthcare(ChildHealthcare childHealthcare) {
        this.childHealthcare = childHealthcare;
    }

    public ConsultationBasic getConsultation() {
        return consultation;
    }

    public void setConsultation(ConsultationBasic consultation) {
        this.consultation = consultation;
    }

    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }

    public DiagnosisFull getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(DiagnosisFull diagnosis) {
        this.diagnosis = diagnosis;
    }

    public DiagnosisFull getComorbidity() {
        return comorbidity;
    }

    public void setComorbidity(DiagnosisFull comorbidity) {
        this.comorbidity = comorbidity;
    }

    public Text4kBase getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(Text4kBase medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public Text4kBase getObjectiveCondition() {
        return objectiveCondition;
    }

    public void setObjectiveCondition(Text4kBase objectiveCondition) {
        this.objectiveCondition = objectiveCondition;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public DiagnosticReport getDiagnosticReport() {
        return diagnosticReport;
    }

    public void setDiagnosticReport(DiagnosticReport diagnosticReport) {
        this.diagnosticReport = diagnosticReport;
    }

    public ConclusionBase getConclusion() {
        return conclusion;
    }

    public void setConclusion(ConclusionBase conclusion) {
        this.conclusion = conclusion;
    }

    public DischargeDispositionBase getDischargeDisposition() {
        return dischargeDisposition;
    }

    public void setDischargeDisposition(DischargeDispositionBase dischargeDisposition) {
        this.dischargeDisposition = dischargeDisposition;
    }

    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }
}
