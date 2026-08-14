package com.nzis.ignatovsoft.nhis.models.nhis.v3.common;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class IntValueBase {

    @XmlAttribute(name = "value", required = true)
    protected Integer value;

    public IntValueBase() {
    }

    public IntValueBase(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
