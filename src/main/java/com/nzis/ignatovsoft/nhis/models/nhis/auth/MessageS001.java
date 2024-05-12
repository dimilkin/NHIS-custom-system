package com.nzis.ignatovsoft.nhis.models.nhis.auth;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "message", namespace = "https://www.his.bg")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageS001 {
    @XmlElement(name = "contents", namespace = "https://www.his.bg", required = true)
    protected ContentsS001 contents;

    public ContentsS001 getContents() {
        return contents;
    }

    public void setContents(ContentsS001 value) {
        this.contents = value;
    }
}

