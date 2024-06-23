package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.format.DateTimeFormatter;

public class ExamsListCellController {

    @FXML
    private Label patientFirstname;

    @FXML
    private Label patientFamilyName;

    @FXML
    private Label patientIdentifierValue;

    @FXML
    private Label examDate;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    private ExamDbModel examDbModel;

    public ExamsListCellController(ExamDbModel examDbModel) {
        this.examDbModel = examDbModel;
    }

    @FXML
    public void initialize() {
        // Update the labels with the exam information
        patientFirstname.setText(examDbModel.getPatient().getFirstName());
        patientFamilyName.setText(examDbModel.getPatient().getLastName());
        patientIdentifierValue.setText(examDbModel.getPatient().getIdentifier());
        String examDateText = examDbModel.getCloseDate().format(formatter);
        examDate.setText(examDateText);
    }
}
