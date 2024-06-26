package com.nzis.ignatovsoft.nhis.models.nhis.x003;

import com.nzis.ignatovsoft.nhis.models.generated.MessageBase;
import jakarta.xml.bind.annotation.*;

import java.io.Serializable;


@XmlRootElement(name = "messageX003", namespace = "https://www.his.bg")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageX003 extends MessageBase implements Serializable {

    @XmlElement(name = "contents", namespace = "https://www.his.bg", required = true)
    private ContentsX003 contents;

    public ContentsX003 getContents() {
        return contents;
    }

    public void setContents(ContentsX003 contents) {
        this.contents = contents;
    }
}
