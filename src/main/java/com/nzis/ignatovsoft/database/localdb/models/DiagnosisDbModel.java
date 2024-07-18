package com.nzis.ignatovsoft.database.localdb.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "diagnosis")
public class DiagnosisDbModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "icd_code")
    private String ICDCode;
    @Column(name = "additional_icd_code")
    private String additionalICDCode;
    private String diagnosisUse;
    private String diagnosisRank;
    private String clinicalStatus;
    private String verificationStatus;
    private LocalDate onsetDateTime;
    private String notes;

    @OneToOne(mappedBy = "diagnosis", cascade = CascadeType.ALL)
    private ExamDbModel exam;

    public String getICDCode() {
        return ICDCode;
    }

    public void setICDCode(String ICDCode) {
        this.ICDCode = ICDCode;
    }

    public String getAdditionalICDCode() {
        return additionalICDCode;
    }

    public void setAdditionalICDCode(String additionalICDCode) {
        this.additionalICDCode = additionalICDCode;
    }

    public String getDiagnosisUse() {
        return diagnosisUse;
    }

    public void setDiagnosisUse(String diagnosisUse) {
        this.diagnosisUse = diagnosisUse;
    }

    public String getDiagnosisRank() {
        return diagnosisRank;
    }

    public void setDiagnosisRank(String diagnosisRank) {
        this.diagnosisRank = diagnosisRank;
    }

    public String getClinicalStatus() {
        return clinicalStatus;
    }

    public void setClinicalStatus(String clinicalStatus) {
        this.clinicalStatus = clinicalStatus;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public LocalDate getOnsetDateTime() {
        return onsetDateTime;
    }

    public void setOnsetDateTime(LocalDate onsetDateTime) {
        this.onsetDateTime = onsetDateTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ExamDbModel getExam() {
        return exam;
    }

    public void setExam(ExamDbModel exam) {
        this.exam = exam;
    }
}
