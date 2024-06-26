package com.nzis.ignatovsoft.database.localdb.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "exams")
public class ExamDbModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String lrn;
    private String nrn;
    private boolean isSecondary;
    private LocalDateTime closeDate;
    private String purpose;
    private String gestationalWeek;
    private boolean isPregnant;
    private boolean isBreastFeeding;
    private String examStatus;
    @Column(name = "medical_history")
    private String medicalHistory;
    @Column(name = "objective_condition")
    private String objectiveCondition;
    private String conclusion;
    @Column(name = "discharge_disposition")
    private String dischargeDisposition;
    private String therapy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private PatientDbModel patient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diagnosis_id", referencedColumnName = "id")
    private DiagnosisDbModel diagnosis;

    public ExamDbModel() {
    }

    public ExamDbModel(String lrn, String nrn, boolean isSecondary, LocalDateTime closeDate, String purpose, String gestationalWeek, boolean isPregnant, boolean isBreastFeeding, String examStatus, PatientDbModel patient, DiagnosisDbModel diagnosis) {
        this.lrn = lrn;
        this.nrn = nrn;
        this.isSecondary = isSecondary;
        this.closeDate = closeDate;
        this.purpose = purpose;
        this.gestationalWeek = gestationalWeek;
        this.isPregnant = isPregnant;
        this.isBreastFeeding = isBreastFeeding;
        this.examStatus = examStatus;
        this.patient = patient;
        this.diagnosis = diagnosis;
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

    public boolean isSecondary() {
        return isSecondary;
    }

    public void setSecondary(boolean secondary) {
        isSecondary = secondary;
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

    public boolean isPregnant() {
        return isPregnant;
    }

    public void setPregnant(boolean pregnant) {
        isPregnant = pregnant;
    }

    public boolean isBreastFeeding() {
        return isBreastFeeding;
    }

    public void setBreastFeeding(boolean breastFeeding) {
        isBreastFeeding = breastFeeding;
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

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String examDateText = closeDate.format(formatter);
        return "Exam from " + examDateText;
    }
}
