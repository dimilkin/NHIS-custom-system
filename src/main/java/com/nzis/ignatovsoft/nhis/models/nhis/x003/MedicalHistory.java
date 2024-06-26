package com.nzis.ignatovsoft.nhis.models.nhis.x003;

import com.nzis.ignatovsoft.nhis.models.nhis.x003.base.NrnAllergyBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class MedicalHistory {

    @XmlElement(name = "status", required = true)
    private String status; // default = 2
    @XmlElement(name = "nrnAllergy", required = false)
    private NrnAllergyBase nrnAllergy;
    @XmlElement(name = "nrnHistory", required = false)
    private NrnAllergyBase nrnHistory;
}
