package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.NomeConstants;
import com.nzis.ignatovsoft.database.localdb.models.PatientDbModel;
import com.nzis.ignatovsoft.dataservices.PatientsDataService;
import com.nzis.ignatovsoft.dtos.PatientDTO;
import com.nzis.ignatovsoft.front.events.PatientUpdateEventHandler;
import com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002.Description;
import com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002.Entry;
import com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002.Key;
import com.nzis.ignatovsoft.nhis.services.NomenclatureService;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class NewPatientDetailsController implements Initializable {


    public TextField firstNameField;
    public TextField middleNameField;
    public TextField lastNameField;
    public ComboBox<Entry> identifierComboBox;
    public TextField identifierValueField;
    public TextField addressField;
    public TextField addressCityName;
    public ComboBox<Entry> countryComboBox;
    public ComboBox<Entry> countyBox;
    public ComboBox<Entry> genderBox;
    public DatePicker birthDatePicker;
    public Button saveButton;
    public Label errorTextField;
    public Label addEditPatientTitle;

    private final PatientsDataService patientsDataService;
    private boolean isEdit = false;
    private String editedPatientIdentifier;


    public NewPatientDetailsController() {
        this.patientsDataService = new PatientsDataService();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorTextField.setVisible(false);
        new Thread(() -> {
            identifierComboBox.setItems(getNomenclatures(NomeConstants.IDENTIFIER_TYPE));
            countryComboBox.setItems(getNomenclatures(NomeConstants.ADDRESS_COUNTRY));
            countyBox.setItems(getNomenclatures(NomeConstants.ADDRESS_COUNTY));
            genderBox.setItems(getNomenclatures(NomeConstants.GENDER_CODE));
        }).start();
        saveButton.setOnMouseClicked(e -> {
            if (isEdit) {
                updatePatient();
                PatientUpdateEventHandler patientUpdateEventHandler = PatientUpdateEventHandler.getInstance();
                patientUpdateEventHandler.setPatientUpdated(true);
                Stage stage = (Stage) saveButton.getScene().getWindow();
                stage.close();
            } else {
                savePatientToDb();
            }
        });
    }

    private void updatePatient() {
        PatientDTO patientDTO;
        try {
            patientDTO = generatePatientDto();
            PatientDTO existingPatient = patientsDataService.getPatientByIdentifierValue(editedPatientIdentifier);
            patientDTO.setId(existingPatient.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Възникна грешка при запазването на данните на пациента", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (patientsDataService.updatePatient(patientDTO)) {
            JOptionPane.showMessageDialog(null, "Данните на пациента са запазени успешно", "Успех", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Възникна грешка при запазването на данните на пациента", "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void savePatientToDb() {
        PatientDTO patientDTO = generatePatientDto();
        if (patientsDataService.savePatient(patientDTO)) {
            JOptionPane.showMessageDialog(null, "Данните на пациента са запазени успешно", "Успех", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Възникна грешка при запазването на данните на пациента", "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public PatientDTO generatePatientDto() {
        String identifier = identifierComboBox.getValue() != null ? identifierComboBox.getValue().getKey().getValue() : null;
        String identifierValue = identifierValueField.getText();
        String birthDate = birthDatePicker.getValue() != null ? birthDatePicker.getValue().toString() : null;
        String gender = genderBox.getValue() != null ? genderBox.getValue().getKey().getValue() : null;
        String firstName = firstNameField.getText();
        String middleName = middleNameField.getText();
        String lastName = lastNameField.getText();
        String country = countryComboBox.getValue() != null ? countryComboBox.getValue().getKey().getValue() : null;
        String county = countyBox.getValue() != null ? countyBox.getValue().getKey().getValue() : null;
        String cityName = addressCityName.getText();

        try {
            checkDataForErrors();
        } catch (IllegalArgumentException e) {
            showErrorMessage(e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }
        return new PatientDTO(identifier, identifierValue, birthDate, gender, firstName, middleName, lastName, country, county, cityName);
    }

    private void checkDataForErrors() {
        if (firstNameField.getText().isEmpty()) {
            throw new IllegalArgumentException("First name is required");
        }
        if (lastNameField.getText().isEmpty()) {
            throw new IllegalArgumentException("Last name is required");
        }
        if (identifierComboBox.getValue() == null) {
            throw new IllegalArgumentException("Identifier type is required");
        }
        if (identifierValueField.getText().isEmpty()) {
            throw new IllegalArgumentException("Identifier value is required");
        }
        if (birthDatePicker.getValue() == null) {
            throw new IllegalArgumentException("Birth date is required");
        }
        if (genderBox.getValue() == null) {
            throw new IllegalArgumentException("Gender value is required");
        }
        if (countryComboBox.getValue() == null) {
            throw new IllegalArgumentException("Country is required");
        }
        if (countyBox.getValue() == null) {
            throw new IllegalArgumentException("County is required");
        }
        if (addressCityName.getText().isEmpty()) {
            throw new IllegalArgumentException("City is required");
        }
    }

    private void showErrorMessage(String message) {
        errorTextField.setText(message);
        errorTextField.setVisible(true);
    }

    public void setPatientData(PatientDbModel selectedPatient) {
        isEdit = true;
        addEditPatientTitle.setText("Промяна на данните на пациент");
        firstNameField.setText(selectedPatient.getFirstName());
        middleNameField.setText(selectedPatient.getMiddleName());
        lastNameField.setText(selectedPatient.getLastName());
        identifierValueField.setText(selectedPatient.getIdentifier());
        editedPatientIdentifier = selectedPatient.getIdentifier();
        addressField.setText(selectedPatient.getAddressCity());
        addressCityName.setText(selectedPatient.getAddressCity());
        birthDatePicker.setValue(selectedPatient.getBirthDate());

        Entry identifierEntry = new Entry();
        Key key = new Key();
        key.setValue(selectedPatient.getIdentifierType());
        identifierEntry.setKey(key);
        identifierComboBox.setValue(identifierEntry);

        identifierComboBox.setValue(identifierEntry);

        Entry genderEntry = new Entry();
        Key genderKey = new Key();
        genderKey.setValue(selectedPatient.getGender());
        genderEntry.setKey(genderKey);

        Entry countryEntry = new Entry();
        Key countryKey = new Key();
        countryKey.setValue(selectedPatient.getAddressCountry());
        countryEntry.setKey(countryKey);

        Entry countyEntry = new Entry();
        Key countyKey = new Key();
        countyKey.setValue(selectedPatient.getAddressCounty());
        countyEntry.setKey(countyKey);
        Description description = new Description();
        description.setValue(selectedPatient.getAddressCounty());
        countyEntry.setDescription(description);

        genderBox.setValue(genderEntry);
        countryComboBox.setValue(countryEntry);
        countyBox.setValue(countyEntry);
    }

    private ObservableList<Entry> getNomenclatures(String identifierType) {
        return NomenclatureService.getInstance().getObservableNomenclatures(identifierType);
    }
}
