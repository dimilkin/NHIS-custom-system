package com.nzis.ignatovsoft.nhis.models.nhis.x099;

import com.nzis.ignatovsoft.nhis.models.generated.MessageBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message", namespace = "https://www.his.bg")
public class MessageX099 extends MessageBase {

    @XmlElement(name = "contents", namespace = "https://www.his.bg")
    private ContentsX099 contents;

    public ContentsX099 getContents() {
        return contents;
    }

    public void setContents(ContentsX099 contents) {
        this.contents = contents;
    }
}
