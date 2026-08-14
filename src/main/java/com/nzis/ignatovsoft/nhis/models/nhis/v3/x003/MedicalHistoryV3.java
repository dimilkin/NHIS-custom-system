package com.nzis.ignatovsoft.nhis.models.nhis.v3.x003;

import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.StringValueBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "medicalHistoryV3", namespace = "http://www.his.bg/", propOrder = {"note"})
public class MedicalHistoryV3 {

    @XmlElement(name = "note", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase note;

    public StringValueBase getNote() {
        return note;
    }

    public void setNote(StringValueBase note) {
        this.note = note;
    }
}
