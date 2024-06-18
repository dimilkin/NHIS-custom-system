package com.nzis.ignatovsoft.nhis.models.nhis.x002;


import com.nzis.ignatovsoft.nhis.models.generated.ContentsBase;
import com.nzis.ignatovsoft.nhis.models.generated.ExaminationStatusBase;
import com.nzis.ignatovsoft.nhis.models.generated.LrnBase;
import com.nzis.ignatovsoft.nhis.models.generated.NrnBase;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "contentsX002")
@XmlType(propOrder = { "nrnExamination", "lrn", "status" })
public class ContentsX002 extends ContentsBase {

    private NrnBase nrnExamination;
    private LrnBase lrn;
    private ExaminationStatusBase status;

    @XmlElement(name = "nrnExamination", required = true)
    public NrnBase getNrnExamination() {
        return nrnExamination;
    }

    public void setNrnExamination(NrnBase nrnExamination) {
        this.nrnExamination = nrnExamination;
    }

    @XmlElement(name = "lrn", required = true)
    public LrnBase getLrn() {
        return lrn;
    }

    public void setLrn(LrnBase lrn) {
        this.lrn = lrn;
    }

    @XmlElement(name = "status", required = true)
    public ExaminationStatusBase getStatus() {
        return status;
    }

    public void setStatus(ExaminationStatusBase status) {
        this.status = status;
    }
}