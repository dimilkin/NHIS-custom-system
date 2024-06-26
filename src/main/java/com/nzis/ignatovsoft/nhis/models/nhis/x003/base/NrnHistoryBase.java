package com.nzis.ignatovsoft.nhis.models.nhis.x003.base;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nrnHistory")
public class NrnHistoryBase {

    private final static long serialVersionUID = -1L;
    @XmlAttribute(name = "value", required = true)
    protected String value;
    @XmlAttribute(name = "dataType")
    protected String dataType;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String value) {
        this.dataType = value;
    }
}
