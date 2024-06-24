package com.nzis.ignatovsoft.dtos;

import java.math.BigInteger;

public class ExamDTO {

    private String nrnExamination;
    private String ICDCode;
    private String additionalIcdCode;
    private String diagnosisUse;
    private BigInteger diagnosisRank;
    private String clinicalStatus;
    private String verificationStatus;
    private String notes;
    private boolean isSecondaryField;
    private String purposeField;
    private BigInteger gestationalWeekField;
    private boolean isPregnantField;
    private boolean isBreastFeedingField;
    private String examStatusField;

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

    public BigInteger getDiagnosisRank() {
        return diagnosisRank;
    }

    public void setDiagnosisRank(BigInteger diagnosisRank) {
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

    public BigInteger getGestationalWeekField() {
        return gestationalWeekField;
    }

    public void setGestationalWeekField(BigInteger gestationalWeekField) {
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
}
