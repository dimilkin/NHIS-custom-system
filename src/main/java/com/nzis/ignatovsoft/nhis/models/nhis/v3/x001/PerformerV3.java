package com.nzis.ignatovsoft.nhis.models.nhis.v3.x001;

import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.StringValueBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "performerV3", namespace = "http://www.his.bg/",
        propOrder = {"pmi", "qualification", "role", "practiceNumber", "phone", "email"})
public class PerformerV3 {

    @XmlElement(name = "pmi", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase pmi;
    @XmlElement(name = "qualification", namespace = "http://www.his.bg/", required = true)
    protected QualificationV3 qualification;
    @XmlElement(name = "role", namespace = "http://www.his.bg/")
    protected StringValueBase role;
    @XmlElement(name = "practiceNumber", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase practiceNumber;
    @XmlElement(name = "phone", namespace = "http://www.his.bg/")
    protected StringValueBase phone;
    @XmlElement(name = "email", namespace = "http://www.his.bg/")
    protected StringValueBase email;

    public StringValueBase getPmi() {
        return pmi;
    }

    public void setPmi(StringValueBase pmi) {
        this.pmi = pmi;
    }

    public QualificationV3 getQualification() {
        return qualification;
    }

    public void setQualification(QualificationV3 qualification) {
        this.qualification = qualification;
    }

    public StringValueBase getRole() {
        return role;
    }

    public void setRole(StringValueBase role) {
        this.role = role;
    }

    public StringValueBase getPracticeNumber() {
        return practiceNumber;
    }

    public void setPracticeNumber(StringValueBase practiceNumber) {
        this.practiceNumber = practiceNumber;
    }

    public StringValueBase getPhone() {
        return phone;
    }

    public void setPhone(StringValueBase phone) {
        this.phone = phone;
    }

    public StringValueBase getEmail() {
        return email;
    }

    public void setEmail(StringValueBase email) {
        this.email = email;
    }
}
