package com.nzis.ignatovsoft.nhis.models.nhis.v3.common;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class StringValueBase {

    @XmlAttribute(name = "value", required = true)
    protected String value;

    public StringValueBase() {
    }

    public StringValueBase(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
