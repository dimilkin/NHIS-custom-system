package com.nzis.ignatovsoft.database.localdb.models;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "patients")
public class PatientDbModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String identifierType;
    private String identifier; //CL004
    private String nhifInsuranceNumber;
    private LocalDate birthDate;
    private String gender; //CL001
    private String firstName;
    private String middleName;
    private String lastName;
    private String addressCity;
    private String addressCounty; //CL041
    private String addressCountry; //CL005
    private String nationality; //CL005
    private String phone;
    private String email;

    public PatientDbModel() {
    }

    public PatientDbModel(long id, String identifierType, String identifier, String nhifInsuranceNumber, LocalDate birthDate, String gender, String firstName, String middleName, String lastName, String addressCity, String addressCounty, String addressCountry, String nationality, String phone, String email) {
        this.id = id;
        this.identifierType = identifierType;
        this.identifier = identifier;
        this.nhifInsuranceNumber = nhifInsuranceNumber;
        this.birthDate = birthDate;
        this.gender = gender;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.addressCity = addressCity;
        this.addressCounty = addressCounty;
        this.addressCountry = addressCountry;
        this.nationality = nationality;
        this.phone = phone;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getNhifInsuranceNumber() {
        return nhifInsuranceNumber;
    }

    public void setNhifInsuranceNumber(String nhifInsuranceNumber) {
        this.nhifInsuranceNumber = nhifInsuranceNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressCounty() {
        return addressCounty;
    }

    public void setAddressCounty(String addressCounty) {
        this.addressCounty = addressCounty;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
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
}
