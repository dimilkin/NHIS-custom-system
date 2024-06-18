package com.nzis.ignatovsoft.nhis.models.nhis.x003;

import com.nzis.ignatovsoft.nhis.models.generated.GestationalWeekBase;
import com.nzis.ignatovsoft.nhis.models.generated.IsBreastFeedingBase;
import com.nzis.ignatovsoft.nhis.models.generated.IsPregnantBase;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "isPregnant", "isBreastFeeding", "gestationalWeek" })
public class MotherHealthcare {

    private IsPregnantBase isPregnant;
    private IsBreastFeedingBase isBreastFeeding;
    private GestationalWeekBase gestationalWeek;

    @XmlElement(name = "isPregnant", required = true)
    public IsPregnantBase getIsPregnant() {
        return isPregnant;
    }

    public void setIsPregnant(IsPregnantBase isPregnant) {
        this.isPregnant = isPregnant;
    }

    @XmlElement(name = "isBreastFeeding", required = true)
    public IsBreastFeedingBase getIsBreastFeeding() {
        return isBreastFeeding;
    }

    public void setIsBreastFeeding(IsBreastFeedingBase isBreastFeeding) {
        this.isBreastFeeding = isBreastFeeding;
    }

    @XmlElement(name = "gestationalWeek")
    public GestationalWeekBase getGestationalWeek() {
        return gestationalWeek;
    }

    public void setGestationalWeek(GestationalWeekBase gestationalWeek) {
        this.gestationalWeek = gestationalWeek;
    }
}
