package com.nzis.ignatovsoft.nhis.models.nhis.v3.x001;

import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.DateTimeValueBase;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.StringValueBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "examinationX001V3", namespace = "http://www.his.bg/",
        propOrder = {"lrn", "openDate", "classBase", "financingSource", "rhifAreaNumber"})
public class ExaminationX001V3 {

    @XmlElement(name = "lrn", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase lrn;
    @XmlElement(name = "openDate", namespace = "http://www.his.bg/", required = true)
    protected DateTimeValueBase openDate;
    @XmlElement(name = "class", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase classBase;
    @XmlElement(name = "financingSource", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase financingSource;
    @XmlElement(name = "rhifAreaNumber", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase rhifAreaNumber;

    public StringValueBase getLrn() {
        return lrn;
    }

    public void setLrn(StringValueBase lrn) {
        this.lrn = lrn;
    }

    public DateTimeValueBase getOpenDate() {
        return openDate;
    }

    public void setOpenDate(DateTimeValueBase openDate) {
        this.openDate = openDate;
    }

    public StringValueBase getClassBase() {
        return classBase;
    }

    public void setClassBase(StringValueBase classBase) {
        this.classBase = classBase;
    }

    public StringValueBase getFinancingSource() {
        return financingSource;
    }

    public void setFinancingSource(StringValueBase financingSource) {
        this.financingSource = financingSource;
    }

    public StringValueBase getRhifAreaNumber() {
        return rhifAreaNumber;
    }

    public void setRhifAreaNumber(StringValueBase rhifAreaNumber) {
        this.rhifAreaNumber = rhifAreaNumber;
    }
}
