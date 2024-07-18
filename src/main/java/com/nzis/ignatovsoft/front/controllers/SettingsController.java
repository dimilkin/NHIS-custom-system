package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.NomeConstants;
import com.nzis.ignatovsoft.database.localdb.models.PracticeInfo;
import com.nzis.ignatovsoft.dataservices.SettingsDataService;
import com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002.Entry;
import com.nzis.ignatovsoft.nhis.services.NomenclatureService;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    public TextField practiceName;
    public TextField doctorsId;
    public ComboBox<Entry> doctorsQualification;
    public TextField tokenPin;
    public Label errorTextField;
    public Button saveButton;

    private final SettingsDataService settingsDataService;
    private final NomenclatureService nomenclatureService;

    public SettingsController() {
        this.settingsDataService = new SettingsDataService();
        this.nomenclatureService = NomenclatureService.getInstance();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorTextField.setVisible(false);
        SettingsDataService settingsDataService = new SettingsDataService();
        PracticeInfo settings = settingsDataService.getSettings();
        if (settings != null) {
            practiceName.setText(setField(settings.getPracticeName()));
            doctorsId.setText(setField(settings.getDoctorId()));
            tokenPin.setText(setField(settings.getSignerPin()));
            doctorsQualification.setValue(nomenclatureService.getCorrectValue(NomeConstants.DOCTORS_QUALIFICATION, settings.getDoctorsQualification()));
        }
        doctorsQualification.setItems(nomenclatureService.getObservableNomenclatures(NomeConstants.DOCTORS_QUALIFICATION));
        saveButton.setOnMouseClicked(e -> {
            updateSettings();
        });
    }

    private void updateSettings() {
        if (validateFields()) {
            settingsDataService.updateSettings(practiceName.getText(), doctorsId.getText(), doctorsQualification.getValue().getKey().getValue(), tokenPin.getText());
        }
    }

    private boolean validateFields() {
        if (practiceName.getText().isEmpty() || doctorsId.getText().isEmpty() || doctorsQualification.getValue() == null || tokenPin.getText().isEmpty()) {
            errorTextField.setText("All fields are required");
            errorTextField.setVisible(true);
            return false;
        }
        return true;
    }

    private String setField(String field) {
        return field == null ? "" : field;
    }
}
