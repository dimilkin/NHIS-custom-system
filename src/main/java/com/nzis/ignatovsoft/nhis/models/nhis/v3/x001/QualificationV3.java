package com.nzis.ignatovsoft.nhis.models.nhis.v3.x001;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class QualificationV3 {

    @XmlAttribute(name = "value", required = true)
    protected String value;
    @XmlAttribute(name = "nhifCode")
    protected String nhifCode;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNhifCode() {
        return nhifCode;
    }

    public void setNhifCode(String nhifCode) {
        this.nhifCode = nhifCode;
    }
}
