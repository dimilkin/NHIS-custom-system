package com.nzis.ignatovsoft.models.nhis;


import com.nzis.ignatovsoft.models.entities.ContentsX002;
import com.nzis.ignatovsoft.models.entities.WarningsBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message", namespace = "https://www.his.bg")
public class StartExaminationResponse {

    @XmlElement(name = "contents", required = true)
    private ContentsX002 contents;

    @XmlElement(name = "warnings")
    private List<WarningsBase> warnings;

    public StartExaminationResponse() {
    }

    public StartExaminationResponse(ContentsX002 contents, List<WarningsBase> warnings) {
        this.contents = contents;
        this.warnings = warnings;
    }

    public ContentsX002 getContents() {
        return contents;
    }

    public void setContents(ContentsX002 contents) {
        this.contents = contents;
    }

    public List<WarningsBase> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<WarningsBase> warnings) {
        this.warnings = warnings;
    }

    @Override
    public String toString() {
        return "Status is " + contents.getStatus();
    }
}