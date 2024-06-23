package com.nzis.ignatovsoft.front.events;

import com.nzis.ignatovsoft.database.localdb.models.PatientDbModel;
import javafx.event.Event;
import javafx.event.EventType;

public class PatientsListCellClickEvent  extends Event {
    public static final EventType<PatientsListCellClickEvent> PATIENT_SELECTED = new EventType<>(Event.ANY, "PATIENT_SELECTED");

    PatientDbModel patient;

    public PatientsListCellClickEvent(PatientDbModel patient) {
        super(PATIENT_SELECTED);
        this.patient = patient;
    }

    public PatientDbModel getPatient() {
        return patient;
    }
}
