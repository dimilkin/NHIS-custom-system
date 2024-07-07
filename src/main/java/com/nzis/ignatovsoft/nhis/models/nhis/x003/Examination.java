package com.nzis.ignatovsoft.nhis.models.nhis.x003;


import com.nzis.ignatovsoft.nhis.models.generated.*;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "examination")
@XmlType(propOrder = {
        "nrnExamination",
        "basedOn",
        "directedBy",
        "isSecondary",
        "purpose",
        "motherHealthcare",
        "childHealthcare",
        "adverseConditions",
        "incidentalVisit",
        "medicalHistory",
        "objectiveCondition",
        "therapy",
        "documents",
        "diagnosis",
        "comorbidity",
        "diagnosticReport",
        "consultation",
        "assessment",
        "conclusion",
        "dischargeDisposition",
        "closeDate"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Examination {

    @XmlElement(name = "nrnExamination", namespace = "https://www.his.bg", required = true)
    private NrnBase nrnExamination;

    @XmlElement(name = "basedOn", namespace = "https://www.his.bg", required = false)
    private DocumentNumberBase basedOn;

    @XmlElement(name = "directedBy",namespace = "https://www.his.bg", required = false)
    private DirectedByBase directedBy;

    @XmlElement(name = "isSecondary", namespace = "https://www.his.bg", required = true)
    private IsSecondaryBase isSecondary;

    @XmlElement(name = "closeDate", namespace = "https://www.his.bg",  required = true)
    private CloseDateBase closeDate;

    @XmlElement(name = "purpose", namespace = "https://www.his.bg", required = true)
    private PurposeBase purpose;

    @XmlElement(name = "incidentalVisit", namespace = "https://www.his.bg", required = true)
    private IncidentalVisitBase incidentalVisit;

    @XmlElement(name = "adverseConditions", namespace = "https://www.his.bg", required = true)
    private AdverseConditionsBase adverseConditions;

    @XmlElement(name = "motherHealthcare", namespace = "https://www.his.bg", required = false)
    private MotherHealthcare motherHealthcare;

    @XmlElement(name = "childHealthcare", namespace = "https://www.his.bg", required = false)
    private ChildHealthcare childHealthcare;

    @XmlElement(name = "consultation",namespace = "https://www.his.bg", required = false)
    private ConsultationBasic consultation;

    @XmlElementWrapper(name = "documents", namespace = "https://www.his.bg", required = false)
    private List<Documents> documents;

    @XmlElement(name = "diagnosis", namespace = "https://www.his.bg", required = true)
    private DiagnosisFull diagnosis;

    @XmlElement(name = "comorbidity", required = false)
    private DiagnosisFull comorbidity;

    @XmlElement(name = "medicalHistory", namespace = "https://www.his.bg", required = false)
    private Text4KBase medicalHistory;

    @XmlElement(name = "objectiveCondition", namespace = "https://www.his.bg", required = false)
    private Text4KBase objectiveCondition;

    @XmlElement(name = "assessment", namespace = "https://www.his.bg", required = false)
    private Assessment assessment;

    @XmlElement(name = "diagnosticReport", required = false)
    private DiagnosticReport diagnosticReport;

    @XmlElement(name = "therapy", namespace = "https://www.his.bg", required = false)
    private Therapy therapy;

    @XmlElement(name = "conclusion", namespace = "https://www.his.bg", required = false)
    private ConclusionBase conclusion;

    @XmlElement(name = "dischargeDisposition", namespace = "https://www.his.bg", required = false)
    private DischargeDispositionBase dischargeDisposition;


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

    public List<Documents> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Documents> documents) {
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

    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }

    public Text4KBase getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(Text4KBase medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public Text4KBase getObjectiveCondition() {
        return objectiveCondition;
    }

    public void setObjectiveCondition(Text4KBase objectiveCondition) {
        this.objectiveCondition = objectiveCondition;
    }
}