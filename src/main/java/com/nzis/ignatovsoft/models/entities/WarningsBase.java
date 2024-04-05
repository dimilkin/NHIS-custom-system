package com.nzis.ignatovsoft.models.entities;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class WarningsBase {

    @XmlElement(name = "code", required = true)
    private String code;

    @XmlElement(name = "description", required = true)
    private String description;

    @XmlElement(name = "source", required = true)
    private String source;

    @XmlElement(name = "nrnTarget", required = true)
    private String nrnTarget;

    // Getters and setters
}