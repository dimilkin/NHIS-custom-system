package com.nzis.ignatovsoft.dtos;

public class ExamDTO {

    private String nrnExamination;
    private String ICDCode;
    private String additionalIcdCode;
    private String diagnosisUse;
    private int diagnosisRank;
    private String clinicalStatus;
    private String verificationStatus;
    private String notes;
    private boolean isSecondaryField;
    private String purposeField;
    private int gestationalWeekField;
    private boolean isPregnantField;
    private boolean isBreastFeedingField;
    private String examStatusField;
    private String medicalHistory;
    private String objectiveCondition;
    private String conclusion;
    private String dischargeDisposition;
    private String therapy;

    public String getNrnExamination() {
        return nrnExamination;
    }

    public void setNrnExamination(String nrnExamination) {
        this.nrnExamination = nrnExamination;
    }

    public String getICDCode() {
        return ICDCode;
    }

    public void setICDCode(String ICDCode) {
        this.ICDCode = ICDCode;
    }

    public String getAdditionalIcdCode() {
        return additionalIcdCode;
    }

    public void setAdditionalIcdCode(String additionalIcdCode) {
        this.additionalIcdCode = additionalIcdCode;
    }

    public String getDiagnosisUse() {
        return diagnosisUse;
    }

    public void setDiagnosisUse(String diagnosisUse) {
        this.diagnosisUse = diagnosisUse;
    }

    public int getDiagnosisRank() {
        return diagnosisRank;
    }

    public void setDiagnosisRank(int diagnosisRank) {
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isSecondaryField() {
        return isSecondaryField;
    }

    public void setSecondaryField(boolean secondaryField) {
        isSecondaryField = secondaryField;
    }

    public String getPurposeField() {
        return purposeField;
    }

    public void setPurposeField(String purposeField) {
        this.purposeField = purposeField;
    }

    public int getGestationalWeekField() {
        return gestationalWeekField;
    }

    public void setGestationalWeekField(int gestationalWeekField) {
        this.gestationalWeekField = gestationalWeekField;
    }

    public boolean isPregnantField() {
        return isPregnantField;
    }

    public void setPregnantField(boolean pregnantField) {
        isPregnantField = pregnantField;
    }

    public boolean isBreastFeedingField() {
        return isBreastFeedingField;
    }

    public void setBreastFeedingField(boolean breastFeedingField) {
        isBreastFeedingField = breastFeedingField;
    }

    public String getExamStatusField() {
        return examStatusField;
    }

    public void setExamStatusField(String examStatusField) {
        this.examStatusField = examStatusField;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getObjectiveCondition() {
        return objectiveCondition;
    }

    public void setObjectiveCondition(String objectiveCondition) {
        this.objectiveCondition = objectiveCondition;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getDischargeDisposition() {
        return dischargeDisposition;
    }

    public void setDischargeDisposition(String dischargeDisposition) {
        this.dischargeDisposition = dischargeDisposition;
    }

    public String getTherapy() {
        return therapy;
    }

    public void setTherapy(String therapy) {
        this.therapy = therapy;
    }
}
