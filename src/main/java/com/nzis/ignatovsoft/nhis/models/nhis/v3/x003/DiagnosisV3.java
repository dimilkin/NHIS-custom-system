package com.nzis.ignatovsoft.nhis.models.nhis.v3.x003;

import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.DateTimeValueBase;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.IntValueBase;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.StringValueBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "diagnosisV3", namespace = "http://www.his.bg/", propOrder = {
        "code", "use", "rank", "clinicalStatus", "verificationStatus", "onsetDateTime", "note"
})
public class DiagnosisV3 {

    @XmlElement(name = "code", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase code;
    @XmlElement(name = "use", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase use;
    @XmlElement(name = "rank", namespace = "http://www.his.bg/", required = true)
    protected IntValueBase rank;
    @XmlElement(name = "clinicalStatus", namespace = "http://www.his.bg/")
    protected StringValueBase clinicalStatus;
    @XmlElement(name = "verificationStatus", namespace = "http://www.his.bg/")
    protected StringValueBase verificationStatus;
    @XmlElement(name = "onsetDateTime", namespace = "http://www.his.bg/")
    protected DateTimeValueBase onsetDateTime;
    @XmlElement(name = "note", namespace = "http://www.his.bg/")
    protected StringValueBase note;

    public StringValueBase getCode() {
        return code;
    }

    public void setCode(StringValueBase code) {
        this.code = code;
    }

    public StringValueBase getUse() {
        return use;
    }

    public void setUse(StringValueBase use) {
        this.use = use;
    }

    public IntValueBase getRank() {
        return rank;
    }

    public void setRank(IntValueBase rank) {
        this.rank = rank;
    }

    public StringValueBase getClinicalStatus() {
        return clinicalStatus;
    }

    public void setClinicalStatus(StringValueBase clinicalStatus) {
        this.clinicalStatus = clinicalStatus;
    }

    public StringValueBase getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(StringValueBase verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public DateTimeValueBase getOnsetDateTime() {
        return onsetDateTime;
    }

    public void setOnsetDateTime(DateTimeValueBase onsetDateTime) {
        this.onsetDateTime = onsetDateTime;
    }

    public StringValueBase getNote() {
        return note;
    }

    public void setNote(StringValueBase note) {
        this.note = note;
    }
}
