package com.nzis.ignatovsoft.nhis.models.nhis.v3.x003;

import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.MessageHeaderV3;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.Serializable;

@XmlRootElement(name = "message", namespace = "http://www.his.bg/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"header", "contents"})
public class MessageX003V3 implements Serializable {

    @XmlElement(name = "header", namespace = "http://www.his.bg/", required = true)
    protected MessageHeaderV3 header;
    @XmlElement(name = "contents", namespace = "http://www.his.bg/", required = true)
    protected ContentsX003V3 contents;

    public MessageHeaderV3 getHeader() {
        return header;
    }

    public void setHeader(MessageHeaderV3 header) {
        this.header = header;
    }

    public ContentsX003V3 getContents() {
        return contents;
    }

    public void setContents(ContentsX003V3 contents) {
        this.contents = contents;
    }
}
