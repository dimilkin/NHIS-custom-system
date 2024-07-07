package com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c001;

import com.nzis.ignatovsoft.nhis.models.generated.ContentsBase;
import com.nzis.ignatovsoft.nhis.models.generated.NomenclatureIdBase;
import com.nzis.ignatovsoft.nhis.models.generated.UpdateDateBase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contentsC001", propOrder = {"nomenclatureId", "updateDate"})
public class ContentsC001 extends ContentsBase {

    @XmlElement(name = "nomenclatureId", namespace = "https://www.his.bg", required = true)
    protected List<NomenclatureIdBase> nomenclatureId;

    @XmlElement(required = false)
    protected UpdateDateBase updateDate;

    public List<NomenclatureIdBase> getNomenclatureId() {
        if (nomenclatureId == null) {
            nomenclatureId = new ArrayList<NomenclatureIdBase>();
        }
        return this.nomenclatureId;
    }

    public UpdateDateBase getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(UpdateDateBase value) {
        this.updateDate = value;
    }
}