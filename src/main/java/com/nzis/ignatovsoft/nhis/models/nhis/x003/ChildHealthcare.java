package com.nzis.ignatovsoft.nhis.models.nhis.x003;

import com.nzis.ignatovsoft.nhis.models.generated.AgeBase;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "age" })
public class ChildHealthcare {

    private AgeBase age;

    @XmlElement(name = "age", required = true)
    public AgeBase getAge() {
        return age;
    }

    public void setAge(AgeBase age) {
        this.age = age;
    }
}
