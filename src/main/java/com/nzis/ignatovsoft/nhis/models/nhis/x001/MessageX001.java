package com.nzis.ignatovsoft.nhis.models.nhis.x001;

import com.nzis.ignatovsoft.nhis.models.generated.MessageBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement(name = "message", namespace = "https://www.his.bg")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageX001 extends MessageBase implements Serializable {

    @XmlElement(name = "contents", namespace = "https://www.his.bg", required = true)
    protected ContentsX001 contents;

    public ContentsX001 getContents() {
        return contents;
    }

    public void setContents(ContentsX001 contents) {
        this.contents = contents;
    }
}
