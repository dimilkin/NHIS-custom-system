package com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002;

import com.nzis.ignatovsoft.nhis.models.generated.NomenclatureIdBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nomenclature", propOrder = {
        "nomenclatureId",
        "entry"
})
public class Nomenclature {

    @XmlElement(name = "nomenclatureId", namespace = "https://www.his.bg", required = true)
    protected NomenclatureIdBase nomenclatureId;

    @XmlElement(name = "entry", namespace = "https://www.his.bg", required = true)
    protected List<Entry> entry;

    public NomenclatureIdBase getNomenclatureId() {
        return nomenclatureId;
    }

    public void setNomenclatureId(NomenclatureIdBase nomenclatureId) {
        this.nomenclatureId = nomenclatureId;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }
}
