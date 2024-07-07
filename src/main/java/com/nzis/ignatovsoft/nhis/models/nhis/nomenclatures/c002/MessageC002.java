package com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002;

import com.nzis.ignatovsoft.nhis.models.generated.MessageBase;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "message", namespace = "https://www.his.bg")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageC002 extends MessageBase {

    @XmlElement(name = "contents", namespace = "https://www.his.bg", required = true)
    protected ContentsC002 contents;

    public ContentsC002 getContents() {
        return contents;
    }

    public void setContents(ContentsC002 value) {
        this.contents = value;
    }
}