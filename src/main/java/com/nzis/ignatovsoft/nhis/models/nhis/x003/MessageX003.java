package com.nzis.ignatovsoft.nhis.models.nhis.x003;

import com.nzis.ignatovsoft.nhis.models.generated.MessageBase;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlRootElement(name = "messageX003")
@XmlType(propOrder = { "contents", "signature" })
public class MessageX003 extends MessageBase {

    private ContentsX003 contents;

    @XmlElement(name = "contents", required = true)
    public ContentsX003 getContents() {
        return contents;
    }

    public void setContents(ContentsX003 contents) {
        this.contents = contents;
    }
}
