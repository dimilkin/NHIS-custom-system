package com.nzis.ignatovsoft.models.entities;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

// Address complex type
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressBase {
    @XmlElement(name = "country")
    private String countryCode;

    @XmlElement(name = "city")
    private String city;

    @XmlElement(name = "line")
    private String addressDetails; // Optional

    public AddressBase(String countryCode, String city, String addressDetails) {
        this.countryCode = countryCode;
        this.city = city;
        this.addressDetails = addressDetails;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }
}
