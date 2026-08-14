package com.nzis.ignatovsoft.nhis.models.nhis.v3.x001;

import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.DateTimeValueBase;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.IntValueBase;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.StringValueBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subjectV3", namespace = "http://www.his.bg/",
        propOrder = {"identifierType", "identifier", "birthDate", "gender", "name", "nationality"})
public class SubjectV3 {

    @XmlElement(name = "identifierType", namespace = "http://www.his.bg/", required = true)
    protected IntValueBase identifierType;
    @XmlElement(name = "identifier", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase identifier;
    @XmlElement(name = "birthDate", namespace = "http://www.his.bg/", required = true)
    protected DateTimeValueBase birthDate;
    @XmlElement(name = "gender", namespace = "http://www.his.bg/", required = true)
    protected IntValueBase gender;
    @XmlElement(name = "name", namespace = "http://www.his.bg/", required = true)
    protected MessageNameV3 name;
    @XmlElement(name = "nationality", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase nationality;

    public IntValueBase getIdentifierType() {
        return identifierType;
    }

    public void setIdentifierType(IntValueBase identifierType) {
        this.identifierType = identifierType;
    }

    public StringValueBase getIdentifier() {
        return identifier;
    }

    public void setIdentifier(StringValueBase identifier) {
        this.identifier = identifier;
    }

    public DateTimeValueBase getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateTimeValueBase birthDate) {
        this.birthDate = birthDate;
    }

    public IntValueBase getGender() {
        return gender;
    }

    public void setGender(IntValueBase gender) {
        this.gender = gender;
    }

    public MessageNameV3 getName() {
        return name;
    }

    public void setName(MessageNameV3 name) {
        this.name = name;
    }

    public StringValueBase getNationality() {
        return nationality;
    }

    public void setNationality(StringValueBase nationality) {
        this.nationality = nationality;
    }
}
