package com.nzis.ignatovsoft.nhis.models.nhis.x001;

import com.nzis.ignatovsoft.nhis.models.generated.MedicalPractitionerWithAccompanying;
import com.nzis.ignatovsoft.nhis.models.generated.Patient;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contentsX001", namespace = "https://www.his.bg")
public class ContentsX001 {
    @XmlElement(name = "examination", namespace = "https://www.his.bg", required = true)
    protected Examination examination;
    @XmlElement(name = "subject", namespace = "https://www.his.bg", required = true)
    protected Patient subject;
    @XmlElement(name = "performer", namespace = "https://www.his.bg", required = true)
    protected MedicalPractitionerWithAccompanying performer;

    public Examination getExamination() {
        return examination;
    }

    public void setExamination(Examination examination) {
        this.examination = examination;
    }

    public Patient getSubject() {
        return subject;
    }

    public void setSubject(Patient subject) {
        this.subject = subject;
    }

    public MedicalPractitionerWithAccompanying getPerformer() {
        return performer;
    }

    public void setPerformer(MedicalPractitionerWithAccompanying performer) {
        this.performer = performer;
    }
}
