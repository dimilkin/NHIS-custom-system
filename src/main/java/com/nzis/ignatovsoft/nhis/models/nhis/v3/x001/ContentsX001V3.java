package com.nzis.ignatovsoft.nhis.models.nhis.v3.x001;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contentsX001V3", namespace = "http://www.his.bg/", propOrder = {"examination", "subject", "performer"})
public class ContentsX001V3 {

    @XmlElement(name = "examination", namespace = "http://www.his.bg/", required = true)
    protected ExaminationX001V3 examination;
    @XmlElement(name = "subject", namespace = "http://www.his.bg/", required = true)
    protected SubjectV3 subject;
    @XmlElement(name = "performer", namespace = "http://www.his.bg/", required = true)
    protected PerformerV3 performer;

    public ExaminationX001V3 getExamination() {
        return examination;
    }

    public void setExamination(ExaminationX001V3 examination) {
        this.examination = examination;
    }

    public SubjectV3 getSubject() {
        return subject;
    }

    public void setSubject(SubjectV3 subject) {
        this.subject = subject;
    }

    public PerformerV3 getPerformer() {
        return performer;
    }

    public void setPerformer(PerformerV3 performer) {
        this.performer = performer;
    }
}
