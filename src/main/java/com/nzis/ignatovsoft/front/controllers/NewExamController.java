package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.adaptors.ExamsAdaptor;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NewExamController implements Initializable {
    public TextField ICDCode;
    public TextField additionalIcdCode;
    public TextField diagnosisUse;
    public TextField diagnosisRank;
    public TextField clinicalStatus;
    public TextField verificationStatus;
    public TextField notes;
    public CheckBox isSecondaryField;
    public TextField purposeField;
    public TextField gestationalWeekField;
    public CheckBox isPregnantField;
    public CheckBox isBreastFeedingField;
    public TextField examStatusField;
    public Button saveExamButton;

    private ExamsAdaptor examsAdaptor;

    public NewExamController() {
        examsAdaptor = new ExamsAdaptor();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveExamButton.setOnMouseClicked(e -> {
            examsAdaptor.sendExamToNhis();
        });
    }
}
