package com.nzis.ignatovsoft.nhis.models.nhis.x003;

import com.nzis.ignatovsoft.nhis.models.generated.AgeBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ChildHealthcare {
    @XmlElement(name = "age", required = true)
    private AgeBase age;

    public AgeBase getAge() {
        return age;
    }

    public void setAge(AgeBase age) {
        this.age = age;
    }
}
