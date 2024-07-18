package com.nzis.ignatovsoft.front.events;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class PatientUpdateEventHandler {

    private static final PatientUpdateEventHandler INSTANCE = new PatientUpdateEventHandler();
    private BooleanProperty patientUpdated = new SimpleBooleanProperty(false);

    public static PatientUpdateEventHandler getInstance() {
        return INSTANCE;
    }

    public BooleanProperty patientUpdatedProperty() {
        return patientUpdated;
    }

    public void setPatientUpdated(boolean patientUpdated) {
        this.patientUpdated.set(patientUpdated);
    }
}
