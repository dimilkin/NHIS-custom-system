package com.nzis.ignatovsoft.nhis.models.nhis.x003;

import com.nzis.ignatovsoft.nhis.models.generated.GestationalWeekBase;
import com.nzis.ignatovsoft.nhis.models.generated.IsBreastFeedingBase;
import com.nzis.ignatovsoft.nhis.models.generated.IsPregnantBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "isPregnant", "isBreastFeeding", "gestationalWeek" })
@XmlAccessorType(XmlAccessType.FIELD)
public class MotherHealthcare {

    @XmlElement(name = "isPregnant", namespace = "https://www.his.bg", required = true)
    private IsPregnantBase isPregnant;
    @XmlElement(name = "isBreastFeeding", namespace = "https://www.his.bg", required = true)
    private IsBreastFeedingBase isBreastFeeding;
    @XmlElement(name = "gestationalWeek", namespace = "https://www.his.bg", required = false)
    private GestationalWeekBase gestationalWeek;


    public IsPregnantBase getIsPregnant() {
        return isPregnant;
    }

    public void setIsPregnant(IsPregnantBase isPregnant) {
        this.isPregnant = isPregnant;
    }


    public IsBreastFeedingBase getIsBreastFeeding() {
        return isBreastFeeding;
    }

    public void setIsBreastFeeding(IsBreastFeedingBase isBreastFeeding) {
        this.isBreastFeeding = isBreastFeeding;
    }

    public GestationalWeekBase getGestationalWeek() {
        return gestationalWeek;
    }

    public void setGestationalWeek(GestationalWeekBase gestationalWeek) {
        this.gestationalWeek = gestationalWeek;
    }
}
