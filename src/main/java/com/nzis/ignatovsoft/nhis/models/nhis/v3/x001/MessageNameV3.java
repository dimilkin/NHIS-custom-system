package com.nzis.ignatovsoft.nhis.models.nhis.v3.x001;

import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.StringValueBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "messageName", namespace = "http://www.his.bg/", propOrder = {"given", "middle", "family"})
public class MessageNameV3 {

    @XmlElement(name = "given", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase given;
    @XmlElement(name = "middle", namespace = "http://www.his.bg/")
    protected StringValueBase middle;
    @XmlElement(name = "family", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase family;

    public StringValueBase getGiven() {
        return given;
    }

    public void setGiven(StringValueBase given) {
        this.given = given;
    }

    public StringValueBase getMiddle() {
        return middle;
    }

    public void setMiddle(StringValueBase middle) {
        this.middle = middle;
    }

    public StringValueBase getFamily() {
        return family;
    }

    public void setFamily(StringValueBase family) {
        this.family = family;
    }
}
