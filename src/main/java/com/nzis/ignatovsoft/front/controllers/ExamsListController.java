package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import com.nzis.ignatovsoft.dataservices.ExamsDataService;
import com.nzis.ignatovsoft.front.events.ExamsListCellClickEvent;
import com.nzis.ignatovsoft.front.views.ExamsCellFactory;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ExamsListController implements Initializable {
    @FXML
    public TextField identifierValueField;

    @FXML
    public Button clearFiltersButton;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatepicker;

    @FXML
    private Button examsFilterButton;

    @FXML
    private ListView<ExamDbModel> examsMainBoardList;

    private final ExamsDataService examsDataService = new ExamsDataService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        examsMainBoardList.setItems(examsDataService.getAllLocalDbExams());
        examsMainBoardList.setCellFactory(e -> new ExamsCellFactory());
        examsMainBoardList.addEventHandler(ExamsListCellClickEvent.EXAM_SELECTED, this::handleExamsCellClick);
        examsFilterButton.setOnMouseClicked(e -> handleExamsFilterButtonAction());
        clearFiltersButton.setDisable(true);
        clearFiltersButton.setOnMouseClicked(e -> handleClearFiltersButtonAction());

    }

    private void handleExamsCellClick(ExamsListCellClickEvent examsListCellClickEvent) {
        ExamDbModel examDbModel = examsListCellClickEvent.getExamDbModel();
    }

    @FXML
    private void handleExamsFilterButtonAction() {
        if (startDatePicker.getValue() == null || endDatepicker.getValue() == null) {
            if (identifierValueField.getText().isEmpty()) {
                examsMainBoardList.setItems(examsDataService.getAllLocalDbExams());
                return;
            }
            if (!identifierValueField.getText().isEmpty()) {
                examsMainBoardList.setItems(examsDataService.getFilteredExamsByIdentifier(identifierValueField.getText()));
                clearFiltersButton.setDisable(false);
                return;
            }
        }

        if (startDatePicker.getValue() != null && endDatepicker.getValue() != null && identifierValueField.getText().isEmpty()) {
            examsMainBoardList.setItems(examsDataService.getFilteredExams(startDatePicker.getValue(), endDatepicker.getValue()));
            clearFiltersButton.setDisable(false);
        }

        if (startDatePicker.getValue() != null && endDatepicker.getValue() != null && !identifierValueField.getText().isEmpty()) {
            examsMainBoardList.setItems(examsDataService.getFilteredExams(startDatePicker.getValue(), endDatepicker.getValue(), identifierValueField.getText()));
            clearFiltersButton.setDisable(false);
        }
    }

    private void handleClearFiltersButtonAction() {
        startDatePicker.setValue(null);
        endDatepicker.setValue(null);
        identifierValueField.clear();
        ObservableList<ExamDbModel> allLocalDbExams = examsDataService.getAllLocalDbExams();
        examsMainBoardList.setItems(allLocalDbExams);
        clearFiltersButton.setDisable(true);
    }
}
