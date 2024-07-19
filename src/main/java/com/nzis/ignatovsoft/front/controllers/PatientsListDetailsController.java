package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import com.nzis.ignatovsoft.database.localdb.models.PatientDbModel;
import com.nzis.ignatovsoft.dataservices.PatientsDataService;
import com.nzis.ignatovsoft.front.events.PatientUpdateEventHandler;
import com.nzis.ignatovsoft.front.events.PatientsListCellClickEvent;
import com.nzis.ignatovsoft.front.views.PatientsCellFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class PatientsListDetailsController implements Initializable {

    @FXML
    public TextField identifierValueField;
    @FXML
    public Button filterButton;
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
    private PatientsDataService patientsDataService = new PatientsDataService();

    public PatientsListDetailsController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadPatientData();
        editButton.setOnAction(e -> handleEditButtonAction());
        filterButton.setOnAction(e -> filterPatientsByIdentifierValue());
    }

    private void filterPatientsByIdentifierValue() {
        String identifierValue = identifierValueField.getText();
        ObservableList<PatientDbModel> filteredPatients = FXCollections.observableArrayList();
        if (identifierValue != null && !identifierValue.isEmpty()) {
            List<PatientDbModel> allLocalDbPatients = patientsDataService.getAllLocalDbPatients();
            allLocalDbPatients = allLocalDbPatients.stream()
                    .filter(patient -> patient.getIdentifier().contains(identifierValue))
                    .collect(Collectors.toList());
            filteredPatients.addAll(allLocalDbPatients);
            patientsList.setItems(filteredPatients);
        } else {
            patientsList.setItems(patientsDataService.getAllLocalDbPatients());
        }
    }

    private void handleEditButtonAction() {
        try {
            // Load the FXML file for the new window
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NewPatientDetails.fxml"));

            // Create the scene and the stage
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);

            NewPatientDetailsController controller = loader.getController();
            controller.setPatientData(selectedPatient);

            PatientUpdateEventHandler patientUpdateEventHandler = PatientUpdateEventHandler.getInstance();
            patientUpdateEventHandler.patientUpdatedProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue) {
                    patientsDataService.refreshLocalDbPatients();
                    loadPatientData();
                    patientsList.refresh();
                    patientUpdateEventHandler.setPatientUpdated(false);
                }
            });

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPatientData() {
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
