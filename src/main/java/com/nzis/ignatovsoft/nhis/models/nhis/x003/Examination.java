package com.nzis.ignatovsoft.nhis.models.nhis.x003;


import com.nzis.ignatovsoft.nhis.models.generated.*;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "examination")
@XmlType(propOrder = {
        "nrnExamination",
        "basedOn",
        "directedBy",
        "isSecondary",
        "closeDate",
        "purpose",
        "plannedType",
        "incidentalVisit",
        "adverseConditions",
        "consultation",
        "documents",
        "diagnosis",
        "comorbidity",
        "medicalHistory",
        "objectiveCondition",
        "assessment",
        "therapy",
        "diagnosticReport",
        "conclusion",
        "dischargeDisposition"
})
public class Examination {


    @XmlElement(name = "nrnExamination", namespace = "https://www.his.bg", required = true)
    private NrnBase nrnExamination;
    @XmlElement(name = "basedOn", namespace = "https://www.his.bg", required = false)
    private DocumentNumberBase basedOn;
    @XmlElement(name = "directedBy", namespace = "https://www.his.bg", required = false)
    private DirectedByBase directedBy;
    @XmlElement(name = "isSecondary" , namespace = "https://www.his.bg", required = true)
    private IsSecondaryBase isSecondary;
    @XmlElement(name = "closeDate" , namespace = "https://www.his.bg", required = true)
    private CloseDateBase closeDate;
    @XmlElement(name = "purpose" , namespace = "https://www.his.bg", required = true)
    private PurposeBase purpose;
    @XmlElement(name = "incidentalVisit" , namespace = "https://www.his.bg", required = true)
    private IncidentalVisitBase incidentalVisit;
    @XmlElement(name = "adverseConditions" , namespace = "https://www.his.bg", required = true)
    private AdverseConditionsBase adverseConditions;
    @XmlElement(name = "consultation" , namespace = "https://www.his.bg", required = false)
    private List<ConsultationBasic> consultation;
    @XmlElement(name = "documents" , namespace = "https://www.his.bg", required = false)
    private Documents documents;
    @XmlElement(name = "diagnosis" , namespace = "https://www.his.bg", required = true)
    private DiagnosisFull diagnosis;
    @XmlElement(name = "comorbidity" , namespace = "https://www.his.bg", required = false)
    private List<DiagnosisFull> comorbidity;
    @XmlElement(name = "assessment" , namespace = "https://www.his.bg", required = false)
    private List<Assessment> assessment;

    @XmlElement(name = "medicalHistory" , namespace = "https://www.his.bg", required = false)
    private MedicalHistory medicalHistory;


    @XmlElement(name = "diagnosticReport" , namespace = "https://www.his.bg", required = false)
    private List<DiagnosticReport> diagnosticReport;
    @XmlElement(name = "conclusion" , namespace = "https://www.his.bg", required = false)
    private ConclusionBase conclusion;
    @XmlElement(name = "dischargeDisposition" , namespace = "https://www.his.bg", required = false)
    private DischargeDispositionBase dischargeDisposition;
    @XmlElement(name = "therapy" , namespace = "https://www.his.bg", required = false)
    private Therapy therapy;

    public NrnBase getNrnExamination() {
        return nrnExamination;
    }

    public void setNrnExamination(NrnBase nrnExamination) {
        this.nrnExamination = nrnExamination;
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

    public DiagnosisFull getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(DiagnosisFull diagnosis) {
        this.diagnosis = diagnosis;
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

    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }

    public List<Assessment> getAssessment() {
        return assessment;
    }

    public void setAssessment(List<Assessment> assessment) {
        this.assessment = assessment;
    }

    public List<DiagnosticReport> getDiagnosticReport() {
        return diagnosticReport;
    }

    public void setDiagnosticReport(List<DiagnosticReport> diagnosticReport) {
        this.diagnosticReport = diagnosticReport;
    }

    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
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

    public List<ConsultationBasic> getConsultation() {
        return consultation;
    }

    public void setConsultation(List<ConsultationBasic> consultation) {
        this.consultation = consultation;
    }

    public List<DiagnosisFull> getComorbidity() {
        return comorbidity;
    }

    public void setComorbidity(List<DiagnosisFull> comorbidity) {
        this.comorbidity = comorbidity;
    }
}