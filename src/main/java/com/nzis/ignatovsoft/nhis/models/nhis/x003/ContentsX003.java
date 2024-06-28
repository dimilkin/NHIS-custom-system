package com.nzis.ignatovsoft.nhis.models.nhis.x003;


import com.nzis.ignatovsoft.nhis.models.generated.ContentsBase;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class ContentsX003 extends ContentsBase {

    @XmlElement(name = "examination", required = true)
    private Examination examination;

    public Examination getExamination() {
        return examination;
    }

    public void setExamination(Examination examination) {
        this.examination = examination;
    }
}