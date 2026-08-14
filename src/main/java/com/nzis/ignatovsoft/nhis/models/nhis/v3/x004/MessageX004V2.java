package com.nzis.ignatovsoft.nhis.models.nhis.v3.x004;

import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.MessageHeaderV3;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.MessageWarning;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "message", namespace = "http://www.his.bg/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"header", "contents", "warnings"})
public class MessageX004V2 implements Serializable {

    @XmlElement(name = "header", namespace = "http://www.his.bg/")
    protected MessageHeaderV3 header;
    @XmlElement(name = "contents", namespace = "http://www.his.bg/")
    protected ContentsX004V2 contents;
    @XmlElement(name = "warnings", namespace = "http://www.his.bg/")
    protected List<MessageWarning> warnings;

    public MessageHeaderV3 getHeader() {
        return header;
    }

    public void setHeader(MessageHeaderV3 header) {
        this.header = header;
    }

    public ContentsX004V2 getContents() {
        return contents;
    }

    public void setContents(ContentsX004V2 contents) {
        this.contents = contents;
    }

    public List<MessageWarning> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<MessageWarning> warnings) {
        this.warnings = warnings;
    }
}
