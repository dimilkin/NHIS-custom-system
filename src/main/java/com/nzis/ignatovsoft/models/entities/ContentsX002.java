package com.nzis.ignatovsoft.models.entities;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ContentsX002 {

    @XmlElement(name = "nrnExamination", required = true)
    private String nrnExamination;

    @XmlElement(name = "lrn", required = true)
    private String lrn;

    @XmlElement(name = "status", required = true)
    private String status;

    public ContentsX002(String nrnExamination, String lrn, String status) {
        this.nrnExamination = nrnExamination;
        this.lrn = lrn;
        this.status = status;
    }

    public String getNrnExamination() {
        return nrnExamination;
    }

    public void setNrnExamination(String nrnExamination) {
        this.nrnExamination = nrnExamination;
    }

    public String getLrn() {
        return lrn;
    }

    public void setLrn(String lrn) {
        this.lrn = lrn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
