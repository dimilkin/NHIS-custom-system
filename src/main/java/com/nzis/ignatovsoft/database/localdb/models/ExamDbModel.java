package com.nzis.ignatovsoft.database.localdb.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "exams")
public class ExamDbModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String lrn;
    private String nrn;
    private String isSecondary;
    private LocalDateTime closeDate;
    private String purpose;
    private String gestationalWeek;
    private String isPregnant;
    private String isBreastFeeding;
    private String examStatus;;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private PatientDbModel patient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diagnosis_id", referencedColumnName = "id")
    private DiagnosisDbModel diagnosis;

    public ExamDbModel() {
    }

    public ExamDbModel( String lrn, String nrn, String isSecondary, LocalDateTime closeDate, String purpose, String gestationalWeek, String isPregnant, String isBreastFeeding, String examStatus) {
        this.lrn = lrn;
        this.nrn = nrn;
        this.isSecondary = isSecondary;
        this.closeDate = closeDate;
        this.purpose = purpose;
        this.gestationalWeek = gestationalWeek;
        this.isPregnant = isPregnant;
        this.isBreastFeeding = isBreastFeeding;
        this.examStatus = examStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLrn() {
        return lrn;
    }

    public void setLrn(String lrn) {
        this.lrn = lrn;
    }

    public String getNrn() {
        return nrn;
    }

    public void setNrn(String nrn) {
        this.nrn = nrn;
    }

    public String getIsSecondary() {
        return isSecondary;
    }

    public void setIsSecondary(String isSecondary) {
        this.isSecondary = isSecondary;
    }

    public LocalDateTime getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDateTime closeDate) {
        this.closeDate = closeDate;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getGestationalWeek() {
        return gestationalWeek;
    }

    public void setGestationalWeek(String gestationalWeek) {
        this.gestationalWeek = gestationalWeek;
    }

    public String getIsPregnant() {
        return isPregnant;
    }

    public void setIsPregnant(String isPregnant) {
        this.isPregnant = isPregnant;
    }

    public String getIsBreastFeeding() {
        return isBreastFeeding;
    }

    public void setIsBreastFeeding(String isBreastFeeding) {
        this.isBreastFeeding = isBreastFeeding;
    }

    public String getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(String examStatus) {
        this.examStatus = examStatus;
    }

    public PatientDbModel getPatient() {
        return patient;
    }

    public void setPatient(PatientDbModel patient) {
        this.patient = patient;
    }

    public DiagnosisDbModel getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(DiagnosisDbModel diagnosis) {
        this.diagnosis = diagnosis;
    }
}
