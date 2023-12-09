package com.nzis.ignatovsoft.front.models;

public class Transaction {

    private String name;
    private String familyName;
    private String timeOfExam;
    private String dateOfExam;
    private String phone;
    private String diagnosis;
    private String procedure;
    private String address;
    private boolean isTransactionSuccesful;

    public Transaction(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }


    public Transaction(String name, String familyName, String dateOfExam, String timeOfExam, String phone, String diagnosis, String procedure, String address, boolean isTransactionSuccesful) {
        this.name = name;
        this.familyName = familyName;
        this.dateOfExam = dateOfExam;
        this.timeOfExam = timeOfExam;
        this.phone = phone;
        this.diagnosis = diagnosis;
        this.procedure = procedure;
        this.address = address;
        this.isTransactionSuccesful = isTransactionSuccesful;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getTimeOfExam() {
        return timeOfExam;
    }

    public String getDateOfExam() {
        return dateOfExam;
    }

    public String getPhone() {
        return phone;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getProcedure() {
        return procedure;
    }

    public String getAddress() {
        return address;
    }

    public boolean isTransactionSuccesful() {
        return isTransactionSuccesful;
    }
}
