package com.nzis.ignatovsoft.nhis.models.nhis.x003;


import com.nzis.ignatovsoft.nhis.models.generated.*;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "examination")
@XmlType(propOrder = {"nrnExamination", "isSecondary", "purpose", "motherHealthcare", "adverseConditions", "incidentalVisit", "diagnosis", "closeDate"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Examination {

    @XmlElement(name = "nrnExamination", required = true)
    private NrnBase nrnExamination;

    @XmlElement(name = "basedOn", required = false)
    private DocumentNumberBase basedOn;

    @XmlElement(name = "directedBy", required = false)
    private DirectedByBase directedBy;

    @XmlElement(name = "isSecondary", required = true)
    private IsSecondaryBase isSecondary;

    @XmlElement(name = "closeDate", required = true)
    private CloseDateBase closeDate;

    @XmlElement(name = "purpose", required = true)
    private PurposeBase purpose;

    @XmlElement(name = "incidentalVisit", required = true)
    private IncidentalVisitBase incidentalVisit;

    @XmlElement(name = "adverseConditions", required = true)
    private AdverseConditionsBase adverseConditions;

    @XmlElement(name = "motherHealthcare", required = true)
    private MotherHealthcare motherHealthcare;

    @XmlElement(name = "diagnosis", required = true)
    private DiagnosisFull diagnosis;

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

    public MotherHealthcare getMotherHealthcare() {
        return motherHealthcare;
    }

    public void setMotherHealthcare(MotherHealthcare motherHealthcare) {
        this.motherHealthcare = motherHealthcare;
    }
}