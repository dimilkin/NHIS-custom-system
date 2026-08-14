package com.nzis.ignatovsoft.nhis.models.nhis.v3.r099;

import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.MessageHeaderV3;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.Serializable;
import java.util.List;

/**
 * The v3 "contents" array has no XML wrapper element in the swagger doc
 * (no "wrapped": true) - it is expected to serialize as repeated
 * &lt;contents&gt; elements directly under &lt;message&gt;, same as the old
 * X099 "error" list wrapped a level differently. Unverified against a live
 * error response - adjust here if the real payload differs.
 */
@XmlRootElement(name = "message", namespace = "http://www.his.bg/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"header", "contents"})
public class MessageR099 implements Serializable {

    @XmlElement(name = "header", namespace = "http://www.his.bg/")
    protected MessageHeaderV3 header;
    @XmlElement(name = "contents", namespace = "http://www.his.bg/")
    protected List<MessageErrorV3> contents;

    public MessageHeaderV3 getHeader() {
        return header;
    }

    public void setHeader(MessageHeaderV3 header) {
        this.header = header;
    }

    public List<MessageErrorV3> getContents() {
        return contents;
    }

    public void setContents(List<MessageErrorV3> contents) {
        this.contents = contents;
    }
}
