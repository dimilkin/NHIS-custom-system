package com.nzis.ignatovsoft.nhis.models.nhis.x002;

import com.nzis.ignatovsoft.nhis.models.generated.Header;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "message", namespace = "https://www.his.bg")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageX002 {
    @XmlElement(name = "header", namespace = "https://www.his.bg")
    private Header header;
    @XmlElement(name = "contents", namespace = "https://www.his.bg")
    private ContentsX002 contents;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public ContentsX002 getContents() {
        return contents;
    }

    public void setContents(ContentsX002 contents) {
        this.contents = contents;
    }
}
