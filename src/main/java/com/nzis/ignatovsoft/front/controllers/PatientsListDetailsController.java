package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import com.nzis.ignatovsoft.database.localdb.models.PatientDbModel;
import com.nzis.ignatovsoft.dataservices.PatientsDataService;
import com.nzis.ignatovsoft.front.events.PatientsListCellClickEvent;
import com.nzis.ignatovsoft.front.views.PatientsCellFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class PatientsListDetailsController implements Initializable {

    @FXML
    private ListView<PatientDbModel> patientsList;
    @FXML
    private ListView<ExamDbModel> examsList;
    @FXML
    private Button editButton;
    @FXML
    private Text firstName;
    @FXML
    private Text midName;
    @FXML
    private Text lastName;
    @FXML
    private Text identifier;
    @FXML
    private Text address;

    private PatientDbModel selectedPatient;

    private  PatientsDataService patientsDataService;



    public PatientsListDetailsController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadPatientData();
    }

    @FXML
    private void handleEditButtonAction() {
        // Logic for when the edit button is clicked
    }

    private void loadPatientData() {
        patientsDataService = new PatientsDataService();
        patientsList.setItems(patientsDataService.getAllLocalDbPatients());
        patientsList.setCellFactory(e -> new PatientsCellFactory());
        patientsList.addEventHandler(PatientsListCellClickEvent.PATIENT_SELECTED, this::handlePatientSelectionEvent);
    }

    private void handlePatientSelectionEvent(PatientsListCellClickEvent patientsListCellClickEvent) {
        selectedPatient = patientsListCellClickEvent.getPatient();
        firstName.setText(selectedPatient.getFirstName());
        midName.setText(selectedPatient.getMiddleName());
        lastName.setText(selectedPatient.getLastName());
        identifier.setText(selectedPatient.getIdentifier());
        String addressString = selectedPatient.getAddressCity() + "; " + selectedPatient.getAddressCountry() + "; " + selectedPatient.getAddressCountry();
        address.setText(addressString);
        ObservableList<ExamDbModel> allExamsForPatient = FXCollections.observableArrayList();
        if (selectedPatient.getExams() != null) {
            allExamsForPatient.addAll(selectedPatient.getExams());
            examsList.setItems(allExamsForPatient);
        } else if (selectedPatient.getExams() == null) {
            examsList.setItems(null);
        }
    }
}
