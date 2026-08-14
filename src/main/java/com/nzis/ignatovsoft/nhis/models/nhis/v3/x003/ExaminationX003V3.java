package com.nzis.ignatovsoft.nhis.models.nhis.v3.x003;

import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.BooleanValueBase;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.DateTimeValueBase;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.StringValueBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "examinationX003V3", namespace = "http://www.his.bg/", propOrder = {
        "nrnExamination", "directedBy", "isSecondary", "closeDate", "purpose",
        "incidentalVisit", "adverseConditions", "diagnosis", "medicalHistory", "objectiveCondition"
})
public class ExaminationX003V3 {

    @XmlElement(name = "nrnExamination", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase nrnExamination;
    @XmlElement(name = "directedBy", namespace = "http://www.his.bg/")
    protected StringValueBase directedBy;
    @XmlElement(name = "isSecondary", namespace = "http://www.his.bg/", required = true)
    protected BooleanValueBase isSecondary;
    @XmlElement(name = "closeDate", namespace = "http://www.his.bg/", required = true)
    protected DateTimeValueBase closeDate;
    @XmlElement(name = "purpose", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase purpose;
    @XmlElement(name = "incidentalVisit", namespace = "http://www.his.bg/", required = true)
    protected BooleanValueBase incidentalVisit;
    @XmlElement(name = "adverseConditions", namespace = "http://www.his.bg/", required = true)
    protected BooleanValueBase adverseConditions;
    @XmlElement(name = "diagnosis", namespace = "http://www.his.bg/", required = true)
    protected DiagnosisV3 diagnosis;
    @XmlElement(name = "medicalHistory", namespace = "http://www.his.bg/", required = true)
    protected MedicalHistoryV3 medicalHistory;
    @XmlElement(name = "objectiveCondition", namespace = "http://www.his.bg/", required = true)
    protected ObjectiveConditionV3 objectiveCondition;

    public StringValueBase getNrnExamination() {
        return nrnExamination;
    }

    public void setNrnExamination(StringValueBase nrnExamination) {
        this.nrnExamination = nrnExamination;
    }

    public StringValueBase getDirectedBy() {
        return directedBy;
    }

    public void setDirectedBy(StringValueBase directedBy) {
        this.directedBy = directedBy;
    }

    public BooleanValueBase getIsSecondary() {
        return isSecondary;
    }

    public void setIsSecondary(BooleanValueBase isSecondary) {
        this.isSecondary = isSecondary;
    }

    public DateTimeValueBase getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(DateTimeValueBase closeDate) {
        this.closeDate = closeDate;
    }

    public StringValueBase getPurpose() {
        return purpose;
    }

    public void setPurpose(StringValueBase purpose) {
        this.purpose = purpose;
    }

    public BooleanValueBase getIncidentalVisit() {
        return incidentalVisit;
    }

    public void setIncidentalVisit(BooleanValueBase incidentalVisit) {
        this.incidentalVisit = incidentalVisit;
    }

    public BooleanValueBase getAdverseConditions() {
        return adverseConditions;
    }

    public void setAdverseConditions(BooleanValueBase adverseConditions) {
        this.adverseConditions = adverseConditions;
    }

    public DiagnosisV3 getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(DiagnosisV3 diagnosis) {
        this.diagnosis = diagnosis;
    }

    public MedicalHistoryV3 getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(MedicalHistoryV3 medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public ObjectiveConditionV3 getObjectiveCondition() {
        return objectiveCondition;
    }

    public void setObjectiveCondition(ObjectiveConditionV3 objectiveCondition) {
        this.objectiveCondition = objectiveCondition;
    }
}
