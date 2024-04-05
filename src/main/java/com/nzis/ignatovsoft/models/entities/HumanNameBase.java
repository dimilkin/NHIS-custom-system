package com.nzis.ignatovsoft.models.entities;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class HumanNameBase {
    @XmlElement(name = "given")
    private String given;

    @XmlElement(name = "middle")
    private String middle; // Optional

    @XmlElement(name = "family")
    private String family;

    public HumanNameBase(String given, String middle, String family) {
        this.given = given;
        this.middle = middle;
        this.family = family;
    }

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}