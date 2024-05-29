package com.nzis.ignatovsoft.database.astraiadb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class AstraiaPatient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String identifier;
    private String firstName;
    private String lastName;
    private String phone;
    private String diagnosis;
    private String pregnant;

    public AstraiaPatient() {
    }

    public AstraiaPatient(int id, String identifier, String firstName, String lastName, String phone, String diagnosis, String pregnant) {
        this.id = id;
        this.identifier = identifier;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.diagnosis = diagnosis;
        this.pregnant = pregnant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPregnant() {
        return pregnant;
    }

    public void setPregnant(String pregnant) {
        this.pregnant = pregnant;
    }
}
