package com.nzis.ignatovsoft.nhis.models.nhis.x099;

import com.nzis.ignatovsoft.nhis.models.generated.ContentsBase;
import com.nzis.ignatovsoft.nhis.models.generated.Error;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ContentsX099 extends ContentsBase {

    @XmlElement(name = "error", namespace = "https://www.his.bg")
    private List<Error> error;

    public List<Error> getError() {
        return error;
    }

    public void setError(List<Error> error) {
        this.error = error;
    }
}
