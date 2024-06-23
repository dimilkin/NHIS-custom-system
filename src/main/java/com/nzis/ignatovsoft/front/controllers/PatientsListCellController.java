package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.database.localdb.models.PatientDbModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PatientsListCellController {
    @FXML
    private Label patient_first_name;
    @FXML
    private Label patient_family_name;
    @FXML
    private Label patient_identifier_value;

    private PatientDbModel patient;

    public PatientsListCellController(PatientDbModel patient) {
        this.patient = patient;
    }

    @FXML
    public void initialize() {
        patient_first_name.setText(patient.getFirstName());
        patient_family_name.setText(patient.getLastName());
        patient_identifier_value.setText(patient.getIdentifier());
    }
}
