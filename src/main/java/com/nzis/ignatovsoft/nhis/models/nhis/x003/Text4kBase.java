package com.nzis.ignatovsoft.nhis.models.nhis.x003;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

@XmlType
public class Text4kBase {

    @XmlAttribute(name = "value", required = true)
    protected String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
