package com.nzis.ignatovsoft.nhis.models.nhis.v3.x002;

import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.StringValueBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contentsX002V2", namespace = "http://www.his.bg/", propOrder = {"nrnExamination", "lrn", "status"})
public class ContentsX002V2 {

    @XmlElement(name = "nrnExamination", namespace = "http://www.his.bg/")
    protected StringValueBase nrnExamination;
    @XmlElement(name = "lrn", namespace = "http://www.his.bg/")
    protected StringValueBase lrn;
    @XmlElement(name = "status", namespace = "http://www.his.bg/")
    protected StringValueBase status;

    public StringValueBase getNrnExamination() {
        return nrnExamination;
    }

    public void setNrnExamination(StringValueBase nrnExamination) {
        this.nrnExamination = nrnExamination;
    }

    public StringValueBase getLrn() {
        return lrn;
    }

    public void setLrn(StringValueBase lrn) {
        this.lrn = lrn;
    }

    public StringValueBase getStatus() {
        return status;
    }

    public void setStatus(StringValueBase status) {
        this.status = status;
    }
}
