package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ExamsListCellController implements Initializable {

    @FXML
    private Label patientFirstname;

    @FXML
    private Label patientFamilyName;

    @FXML
    private Label patientIdentifierValue;

    @FXML
    private Button detailsButton;

    @FXML
    private Label examDate;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    private ExamDbModel examDbModel;

    public ExamsListCellController(ExamDbModel examDbModel) {
        this.examDbModel = examDbModel;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        patientFirstname.setText(examDbModel.getPatient().getFirstName());
        patientFamilyName.setText(examDbModel.getPatient().getLastName());
        patientIdentifierValue.setText(examDbModel.getPatient().getIdentifier());
        String examDateText = examDbModel.getCloseDate().format(formatter);
        examDate.setText(examDateText);
        detailsButton.setOnAction(e -> {
            openExamDetailsWindow(examDbModel);
        });
    }

    private void openExamDetailsWindow(ExamDbModel examDbModel) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ExamDetailsWindow.fxml"));

        try {
            Scene scene = new Scene(loader.load());
            ExamDetailsWindowController controller = loader.getController();
            controller.setExaminationData(examDbModel);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();  // Show the stage
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
