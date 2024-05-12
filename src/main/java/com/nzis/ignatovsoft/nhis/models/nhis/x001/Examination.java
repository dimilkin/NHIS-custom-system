package com.nzis.ignatovsoft.nhis.models.nhis.x001;

import com.nzis.ignatovsoft.nhis.models.generated.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "examination", namespace = "https://www.his.bg")
public class Examination {

    @XmlElement(name = "lrn", namespace = "https://www.his.bg", required = true)
    protected LrnBase lrn;
    @XmlElement(name = "openDate", namespace = "https://www.his.bg", required = true)
    protected OpenDateBase openDate;
    @XmlElement(name = "class", namespace = "https://www.his.bg", required = true)
    protected ClassBase classBase;
    @XmlElement(name = "financingSource", namespace = "https://www.his.bg", required = true)
    protected FinancingSourceBase financingSource;
    @XmlElement(name = "rhifAreaNumber", namespace = "https://www.his.bg", required = true)
    protected RhifAreaNumberBase rhifAreaNumber;

    public LrnBase getLrn() {
        return lrn;
    }

    public void setLrn(LrnBase lrn) {
        this.lrn = lrn;
    }

    public OpenDateBase getOpenDate() {
        return openDate;
    }

    public void setOpenDate(OpenDateBase openDate) {
        this.openDate = openDate;
    }

    public ClassBase getClassBase() {
        return classBase;
    }

    public void setClassBase(ClassBase classBase) {
        this.classBase = classBase;
    }

    public FinancingSourceBase getFinancingSource() {
        return financingSource;
    }

    public void setFinancingSource(FinancingSourceBase financingSource) {
        this.financingSource = financingSource;
    }

    public RhifAreaNumberBase getRhifAreaNumber() {
        return rhifAreaNumber;
    }

    public void setRhifAreaNumber(RhifAreaNumberBase rhifAreaNumber) {
        this.rhifAreaNumber = rhifAreaNumber;
    }
}
