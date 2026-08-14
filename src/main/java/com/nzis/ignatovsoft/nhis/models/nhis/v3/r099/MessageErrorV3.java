package com.nzis.ignatovsoft.nhis.models.nhis.v3.r099;

import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.StringValueBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "messageErrorV3", namespace = "http://www.his.bg/", propOrder = {
        "type", "reason", "description", "faultyAttribute"
})
public class MessageErrorV3 {

    @XmlElement(name = "type", namespace = "http://www.his.bg/")
    protected StringValueBase type;
    @XmlElement(name = "reason", namespace = "http://www.his.bg/")
    protected StringValueBase reason;
    @XmlElement(name = "description", namespace = "http://www.his.bg/")
    protected StringValueBase description;
    @XmlElement(name = "faultyAttribute", namespace = "http://www.his.bg/")
    protected StringValueBase faultyAttribute;

    public StringValueBase getType() {
        return type;
    }

    public void setType(StringValueBase type) {
        this.type = type;
    }

    public StringValueBase getReason() {
        return reason;
    }

    public void setReason(StringValueBase reason) {
        this.reason = reason;
    }

    public StringValueBase getDescription() {
        return description;
    }

    public void setDescription(StringValueBase description) {
        this.description = description;
    }

    public StringValueBase getFaultyAttribute() {
        return faultyAttribute;
    }

    public void setFaultyAttribute(StringValueBase faultyAttribute) {
        this.faultyAttribute = faultyAttribute;
    }
}
