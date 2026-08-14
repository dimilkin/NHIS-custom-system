package com.nzis.ignatovsoft.nhis.models.nhis.v3.common;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "messageWarning", propOrder = {"code", "description", "source", "nrnTarget"})
public class MessageWarning {

    @XmlElement(name = "code", namespace = "http://www.his.bg/")
    protected StringValueBase code;
    @XmlElement(name = "description", namespace = "http://www.his.bg/")
    protected StringValueBase description;
    @XmlElement(name = "source", namespace = "http://www.his.bg/")
    protected StringValueBase source;
    @XmlElement(name = "nrnTarget", namespace = "http://www.his.bg/")
    protected StringValueBase nrnTarget;

    public StringValueBase getCode() {
        return code;
    }

    public void setCode(StringValueBase code) {
        this.code = code;
    }

    public StringValueBase getDescription() {
        return description;
    }

    public void setDescription(StringValueBase description) {
        this.description = description;
    }

    public StringValueBase getSource() {
        return source;
    }

    public void setSource(StringValueBase source) {
        this.source = source;
    }

    public StringValueBase getNrnTarget() {
        return nrnTarget;
    }

    public void setNrnTarget(StringValueBase nrnTarget) {
        this.nrnTarget = nrnTarget;
    }
}
