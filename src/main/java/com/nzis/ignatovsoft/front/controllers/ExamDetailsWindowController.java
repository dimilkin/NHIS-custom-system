package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.NomeConstants;
import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import com.nzis.ignatovsoft.nhis.services.NomenclatureService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ExamDetailsWindowController implements Initializable {
    @FXML
    public Label examinationDate;
    @FXML
    public Label patientFirstName;
    @FXML
    public Label patientLastName;
    @FXML
    public Label patientIdentifierValue;
    @FXML
    public Label diagnosisMainDescription;
    @FXML
    public Label examStatus;
    @FXML
    public Button closeButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        examinationDate.setText("");
        patientFirstName.setText("");
        patientLastName.setText("");
        patientIdentifierValue.setText("");
        diagnosisMainDescription.setText("");
        examStatus.setText("");
        closeButton.setOnAction(event -> {
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        });
    }

    public void setExaminationData(ExamDbModel examinationData) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        examinationDate.setText(examinationData.getCloseDate().format(formatter));
        patientFirstName.setText(examinationData.getPatient().getFirstName());
        patientLastName.setText(examinationData.getPatient().getLastName());
        patientIdentifierValue.setText(examinationData.getPatient().getIdentifier());
        diagnosisMainDescription.setText(getDiagnosisDescription(examinationData));
        examStatus.setText(examinationData.getExamStatus());
    }

    private String getDiagnosisDescription(ExamDbModel examinationData) {
        String diagnosisDescription = examinationData.getDiagnosis().getICDCode();
        NomenclatureService nomenclatureService = NomenclatureService.getInstance();
        return nomenclatureService.getCorrectValue(NomeConstants.ICD_CODES, diagnosisDescription).getDescription().getValue();
    }
}
