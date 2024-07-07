package com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002;

import com.nzis.ignatovsoft.nhis.models.generated.ContentsBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contentsC002", propOrder = {"nomenclature"})
public class ContentsC002 extends ContentsBase {

    @XmlElement(name = "nomenclature", namespace = "https://www.his.bg", required = true)
    protected List<Nomenclature> nomenclature;

    public List<Nomenclature> getNomenclature() {
        if (nomenclature == null) {
            nomenclature = new ArrayList<Nomenclature>();
        }
        return this.nomenclature;
    }
}
