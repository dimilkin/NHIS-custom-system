package com.nzis.ignatovsoft.nhis.models.nhis.v3.common;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class BooleanValueBase {

    @XmlAttribute(name = "value", required = true)
    protected Boolean value;

    public BooleanValueBase() {
    }

    public BooleanValueBase(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}
