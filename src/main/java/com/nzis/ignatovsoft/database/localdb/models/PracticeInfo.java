package com.nzis.ignatovsoft.database.localdb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "practice_info")
public class PracticeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private  String practiceName;;
    private  String practiceAddress;
    private String doctorName;
    private String doctorsQualification;
    private String doctorId;
    private String signerPin;

    public PracticeInfo() {
    }

    public PracticeInfo(String practiceName, String practiceAddress, String doctorName, String doctorPhone, String doctorId, String signerPin) {
        this.practiceName = practiceName;
        this.practiceAddress = practiceAddress;
        this.doctorName = doctorName;
        this.doctorsQualification = doctorPhone;
        this.doctorId = doctorId;
        this.signerPin = signerPin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPracticeName() {
        return practiceName;
    }

    public void setPracticeName(String practiceName) {
        this.practiceName = practiceName;
    }

    public String getPracticeAddress() {
        return practiceAddress;
    }

    public void setPracticeAddress(String practiceAddress) {
        this.practiceAddress = practiceAddress;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorsQualification() {
        return doctorsQualification;
    }

    public void setDoctorsQualification(String doctorPhone) {
        this.doctorsQualification = doctorPhone;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getSignerPin() {
        return signerPin;
    }

    public void setSignerPin(String signerPin) {
        this.signerPin = signerPin;
    }
}
