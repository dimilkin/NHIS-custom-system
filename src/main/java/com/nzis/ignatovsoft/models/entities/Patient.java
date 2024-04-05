package com.nzis.ignatovsoft.models.entities;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Patient {
    @XmlElement(name = "identifierType")
    private String identifierType;

    @XmlElement(name = "identifier")
    private String identifier;

    @XmlElement(name = "nhifInsuranceNumber")
    private String nhifInsuranceNumber; // Optional

    @XmlElement(name = "birthDate")
    private String birthDate;

    @XmlElement(name = "gender")
    private String gender;

    @XmlElement(name = "name")
    private HumanNameBase name;

    @XmlElement(name = "address")
    private AddressBase address;

    @XmlElement(name = "nationality")
    private String nationality; // Optional

    @XmlElement(name = "phone")
    private String phone; // Optional

    @XmlElement(name = "email")
    private String email; // Optional

    public
    Patient(String identifierType, String identifier, String nhifInsuranceNumber, String birthDate, String gender,
                   HumanNameBase name, AddressBase address, String nationality, String phone, String email) {
        this.identifierType = identifierType;
        this.identifier = identifier;
        this.nhifInsuranceNumber = nhifInsuranceNumber;
        this.birthDate = birthDate;
        this.gender = gender;
        this.name = name;
        this.address = address;
        this.nationality = nationality;
        this.phone = phone;
        this.email = email;
    }

    public String getIdentifierType() {
        return identifierType;
    }

    public void setIdentifierType(String identifierType) {
        this.identifierType = identifierType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public HumanNameBase getName() {
        return name;
    }

    public void setName(HumanNameBase name) {
        this.name = name;
    }

    public AddressBase getAddress() {
        return address;
    }

    public void setAddress(AddressBase address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNhifInsuranceNumber() {
        return nhifInsuranceNumber;
    }

    public void setNhifInsuranceNumber(String nhifInsuranceNumber) {
        this.nhifInsuranceNumber = nhifInsuranceNumber;
    }
}
