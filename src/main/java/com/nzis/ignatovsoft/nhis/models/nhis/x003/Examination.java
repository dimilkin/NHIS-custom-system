package com.nzis.ignatovsoft.nhis.models.nhis.x003;


import com.nzis.ignatovsoft.nhis.models.generated.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "examination")
@XmlType(propOrder = { "nrnExamination", "isSecondary", "closeDate", "purpose", "incidentalVisit", "adverseConditions", "diagnosis" })
public class Examination {

    private NrnBase nrnExamination;
    private IsSecondaryBase isSecondary;
    private CloseDateBase closeDate;
    private PurposeBase purpose;
    private IncidentalVisitBase incidentalVisit;
    private AdverseConditionsBase adverseConditions;
    private MotherHealthcare motherHealthcare;
    private DiagnosisFull diagnosis;

    @XmlElement(name = "nrnExamination", required = true)
    public NrnBase getNrnExamination() {
        return nrnExamination;
    }

    public void setNrnExamination(NrnBase nrnExamination) {
        this.nrnExamination = nrnExamination;
    }

    @XmlElement(name = "isSecondary", required = true)
    public IsSecondaryBase getIsSecondary() {
        return isSecondary;
    }

    public void setIsSecondary(IsSecondaryBase isSecondary) {
        this.isSecondary = isSecondary;
    }

    @XmlElement(name = "closeDate", required = true)
    public CloseDateBase getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(CloseDateBase closeDate) {
        this.closeDate = closeDate;
    }

    @XmlElement(name = "purpose", required = true)
    public PurposeBase getPurpose() {
        return purpose;
    }

    public void setPurpose(PurposeBase purpose) {
        this.purpose = purpose;
    }

    @XmlElement(name = "incidentalVisit", required = true)
    public IncidentalVisitBase getIncidentalVisit() {
        return incidentalVisit;
    }

    public void setIncidentalVisit(IncidentalVisitBase incidentalVisit) {
        this.incidentalVisit = incidentalVisit;
    }

    @XmlElement(name = "adverseConditions", required = true)
    public AdverseConditionsBase getAdverseConditions() {
        return adverseConditions;
    }

    public void setAdverseConditions(AdverseConditionsBase adverseConditions) {
        this.adverseConditions = adverseConditions;
    }

    @XmlElement(name = "diagnosis", required = true)
    public DiagnosisFull getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(DiagnosisFull diagnosis) {
        this.diagnosis = diagnosis;
    }

    @XmlElement(name = "motherHealthcare", required = true)
    public MotherHealthcare getMotherHealthcare() {
        return motherHealthcare;
    }

    public void setMotherHealthcare(MotherHealthcare motherHealthcare) {
        this.motherHealthcare = motherHealthcare;
    }
}