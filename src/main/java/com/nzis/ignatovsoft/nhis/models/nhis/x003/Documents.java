package com.nzis.ignatovsoft.nhis.models.nhis.x003;

import com.nzis.ignatovsoft.nhis.models.generated.IssuedDocumentBase;
import com.nzis.ignatovsoft.nhis.models.generated.NrnBase;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "nrnImmunization", "nrnReferral", "nrnPrescription", "issuedTelkDocument", "issuedQuickNotice", "issuedInterimReport", "issuedMedicalNotice" })
public class Documents {

    private NrnBase nrnImmunization;
    private NrnBase nrnReferral;
    private NrnBase nrnPrescription;
    private IssuedDocumentBase issuedTelkDocument;
    private IssuedDocumentBase issuedQuickNotice;
    private IssuedDocumentBase issuedInterimReport;
    private IssuedDocumentBase issuedMedicalNotice;

    public NrnBase getNrnImmunization() {
        return nrnImmunization;
    }

    public void setNrnImmunization(NrnBase nrnImmunization) {
        this.nrnImmunization = nrnImmunization;
    }

    public NrnBase getNrnReferral() {
        return nrnReferral;
    }

    public void setNrnReferral(NrnBase nrnReferral) {
        this.nrnReferral = nrnReferral;
    }

    public NrnBase getNrnPrescription() {
        return nrnPrescription;
    }

    public void setNrnPrescription(NrnBase nrnPrescription) {
        this.nrnPrescription = nrnPrescription;
    }

    public IssuedDocumentBase getIssuedTelkDocument() {
        return issuedTelkDocument;
    }

    public void setIssuedTelkDocument(IssuedDocumentBase issuedTelkDocument) {
        this.issuedTelkDocument = issuedTelkDocument;
    }

    public IssuedDocumentBase getIssuedQuickNotice() {
        return issuedQuickNotice;
    }

    public void setIssuedQuickNotice(IssuedDocumentBase issuedQuickNotice) {
        this.issuedQuickNotice = issuedQuickNotice;
    }

    public IssuedDocumentBase getIssuedInterimReport() {
        return issuedInterimReport;
    }

    public void setIssuedInterimReport(IssuedDocumentBase issuedInterimReport) {
        this.issuedInterimReport = issuedInterimReport;
    }

    public IssuedDocumentBase getIssuedMedicalNotice() {
        return issuedMedicalNotice;
    }

    public void setIssuedMedicalNotice(IssuedDocumentBase issuedMedicalNotice) {
        this.issuedMedicalNotice = issuedMedicalNotice;
    }
}