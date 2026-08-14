package com.nzis.ignatovsoft.nhis.models.nhis.v3.x003;

import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.BooleanValueBase;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.IntValueBase;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.StringValueBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "objectiveConditionV3", namespace = "http://www.his.bg/", propOrder = {
        "isPregnant", "isBreastFeeding", "gestationalWeek", "note"
})
public class ObjectiveConditionV3 {

    @XmlElement(name = "isPregnant", namespace = "http://www.his.bg/")
    protected BooleanValueBase isPregnant;
    @XmlElement(name = "isBreastFeeding", namespace = "http://www.his.bg/")
    protected BooleanValueBase isBreastFeeding;
    @XmlElement(name = "gestationalWeek", namespace = "http://www.his.bg/")
    protected IntValueBase gestationalWeek;
    @XmlElement(name = "note", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase note;

    public BooleanValueBase getIsPregnant() {
        return isPregnant;
    }

    public void setIsPregnant(BooleanValueBase isPregnant) {
        this.isPregnant = isPregnant;
    }

    public BooleanValueBase getIsBreastFeeding() {
        return isBreastFeeding;
    }

    public void setIsBreastFeeding(BooleanValueBase isBreastFeeding) {
        this.isBreastFeeding = isBreastFeeding;
    }

    public IntValueBase getGestationalWeek() {
        return gestationalWeek;
    }

    public void setGestationalWeek(IntValueBase gestationalWeek) {
        this.gestationalWeek = gestationalWeek;
    }

    public StringValueBase getNote() {
        return note;
    }

    public void setNote(StringValueBase note) {
        this.note = note;
    }
}
