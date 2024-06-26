package com.nzis.ignatovsoft.nhis.models.nhis.x002;


import com.nzis.ignatovsoft.nhis.models.generated.ExaminationStatusBase;
import com.nzis.ignatovsoft.nhis.models.generated.LrnBase;
import com.nzis.ignatovsoft.nhis.models.generated.NrnBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.Serializable;

@XmlType(propOrder = { "nrnExamination", "lrn", "status" })
@XmlAccessorType(XmlAccessType.FIELD)
public class ContentsX002 implements Serializable {

    @XmlElement(name = "nrnExamination", namespace = "https://www.his.bg",  required = true)
    private NrnBase nrnExamination;

    @XmlElement(name = "lrn", namespace = "https://www.his.bg", required = true)
    private LrnBase lrn;

    @XmlElement(name = "status", namespace = "https://www.his.bg", required = true)
    private ExaminationStatusBase status;


    public NrnBase getNrnExamination() {
        return nrnExamination;
    }

    public void setNrnExamination(NrnBase nrnExamination) {
        this.nrnExamination = nrnExamination;
    }

    public LrnBase getLrn() {
        return lrn;
    }

    public void setLrn(LrnBase lrn) {
        this.lrn = lrn;
    }

    public ExaminationStatusBase getStatus() {
        return status;
    }

    public void setStatus(ExaminationStatusBase status) {
        this.status = status;
    }
}