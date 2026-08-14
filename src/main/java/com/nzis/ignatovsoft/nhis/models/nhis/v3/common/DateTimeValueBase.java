package com.nzis.ignatovsoft.nhis.models.nhis.v3.common;

import com.nzis.ignatovsoft.nhis.models.generated.Adapter1;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Calendar;

@XmlAccessorType(XmlAccessType.FIELD)
public class DateTimeValueBase {

    @XmlAttribute(name = "value", required = true)
    @XmlJavaTypeAdapter(Adapter1.class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar value;

    public DateTimeValueBase() {
    }

    public DateTimeValueBase(Calendar value) {
        this.value = value;
    }

    public Calendar getValue() {
        return value;
    }

    public void setValue(Calendar value) {
        this.value = value;
    }
}
