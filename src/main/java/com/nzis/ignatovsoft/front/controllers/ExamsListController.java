package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import com.nzis.ignatovsoft.dataservices.ExamsDataService;
import com.nzis.ignatovsoft.front.events.ExamsListCellClickEvent;
import com.nzis.ignatovsoft.front.views.ExamsCellFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ExamsListController implements Initializable {

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatepicker;

    @FXML
    private Button examsFilterButton;

    @FXML
    private ListView<ExamDbModel> examsMainBoardList;

    private final ExamsDataService examsDataService  = new ExamsDataService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        examsMainBoardList.setItems(examsDataService.getAllLocalDbExams());
        examsMainBoardList.setCellFactory(e -> new ExamsCellFactory());
        examsMainBoardList.addEventHandler(ExamsListCellClickEvent.EXAM_SELECTED, this::handleExamsCellClick);

    }

    private void handleExamsCellClick(ExamsListCellClickEvent examsListCellClickEvent) {
        ExamDbModel examDbModel = examsListCellClickEvent.getExamDbModel();
    }

    @FXML
    private void handleExamsFilterButtonAction() {
        // Logic for when the filter button is clicked
    }

}
