package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.NomeConstants;
import com.nzis.ignatovsoft.dataservices.PatientsDataService;
import com.nzis.ignatovsoft.dtos.PatientDTO;
import com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002.Entry;
import com.nzis.ignatovsoft.nhis.services.NomenclatureService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
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

    private PatientsDataService patientsDataService;



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
            savePatientToDb();

        });
    }

    private void savePatientToDb() {
        try {
            PatientDTO patientDTO = generatePatientDto();
            patientsDataService.savePatient(patientDTO);
        } catch (IllegalArgumentException ex) {
            System.out.println("No data");
        }
    }

    private ObservableList<Entry> getNomenclatures(String code) {
        return FXCollections.observableArrayList(fetchNomenclatures(code));
    }

    private List<Entry> fetchNomenclatures(String code) {
        return NomenclatureService.getInstance().getNomenclaturesForCode(code);
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

    private void showErrorMessage (String message) {
        errorTextField.setText(message);
        errorTextField.setVisible(true);
    }
}
