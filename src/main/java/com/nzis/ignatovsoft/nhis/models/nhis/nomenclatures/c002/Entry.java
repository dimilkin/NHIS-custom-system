package com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entry", propOrder = {
        "key",
        "description",
        "meta"
})
public class
Entry {

    @XmlElement(name = "key", namespace = "https://www.his.bg", required = true)
    protected Key key;

    @XmlElement(name = "description", namespace = "https://www.his.bg", required = true)
    protected Description description;

    @XmlElement(name = "meta", namespace = "https://www.his.bg", required = true)
    protected List<Meta> meta;

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public List<Meta> getMeta() {
        return meta;
    }

    public void setMeta(List<Meta> meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        if (description != null){
            return description.getValue();
        }
        return "";
    }
}