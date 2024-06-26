package com.nzis.ignatovsoft.configurations.application;

import com.nzis.ignatovsoft.database.localdb.repos.PracticeInfoRepo;

public class DoctorInfo {
    private String doctorsId;
    private  String practiceName;;
    private  String practiceAddress;
    private String doctorName;
    private String doctorPhone;
    private String signerPin;

    private PracticeInfoRepo practiceInfoRepo;



//    public DoctorInfo() {
//        practiceInfoRepo = new PracticeInfoRepoImpl();
//        doctorsId = practiceInfoRepo.getPracticeInfo().getDoctorId();
//        practiceName = practiceInfoRepo.getPracticeInfo().getPracticeName();
//        practiceAddress = practiceInfoRepo.getPracticeInfo().getPracticeAddress();
//        doctorName = practiceInfoRepo.getPracticeInfo().getDoctorName();
//        doctorPhone = practiceInfoRepo.getPracticeInfo().getDoctorPhone();
//        signerPin = practiceInfoRepo.getPracticeInfo().getSignerPin();
//    }

    public String getDoctorsId() {
        return doctorsId;
    }

    public void setDoctorsId(String doctorsId) {
        this.doctorsId = doctorsId;
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

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getSignerPin() {
        return signerPin;
    }

    public void setSignerPin(String signerPin) {
        this.signerPin = signerPin;
    }

    public PracticeInfoRepo getPracticeInfoRepo() {
        return practiceInfoRepo;
    }

    public void setPracticeInfoRepo(PracticeInfoRepo practiceInfoRepo) {
        this.practiceInfoRepo = practiceInfoRepo;
    }
}
