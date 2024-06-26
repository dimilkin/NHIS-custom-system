package com.nzis.ignatovsoft.nhis.models.nhis.x003;


import com.nzis.ignatovsoft.nhis.models.generated.ContentsBase;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "contentsX003", namespace = "https://www.his.bg")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContentsX003 extends ContentsBase {

    @XmlElement(name = "examination", namespace = "https://www.his.bg", required = true)
    private Examination examination;

    public Examination getExamination() {
        return examination;
    }

    public void setExamination(Examination examination) {
        this.examination = examination;
    }
}