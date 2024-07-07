package com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c001;


import com.nzis.ignatovsoft.nhis.models.generated.MessageBase;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message", namespace = "https://www.his.bg")
public class MessageC001 extends MessageBase {

    @XmlElement(name = "contents", namespace = "https://www.his.bg", required = true)
    protected ContentsC001 contents;

    public ContentsC001 getContents() {
        return contents;
    }

    public void setContents(ContentsC001 value) {
        this.contents = value;
    }
}
