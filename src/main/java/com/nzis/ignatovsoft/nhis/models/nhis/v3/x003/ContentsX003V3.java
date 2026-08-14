package com.nzis.ignatovsoft.nhis.models.nhis.v3.x003;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contentsX003V3", namespace = "http://www.his.bg/", propOrder = {"examination"})
public class ContentsX003V3 {

    @XmlElement(name = "examination", namespace = "http://www.his.bg/", required = true)
    protected ExaminationX003V3 examination;

    public ExaminationX003V3 getExamination() {
        return examination;
    }

    public void setExamination(ExaminationX003V3 examination) {
        this.examination = examination;
    }
}
