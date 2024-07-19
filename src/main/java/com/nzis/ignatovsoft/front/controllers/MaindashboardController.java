package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import com.nzis.ignatovsoft.dataservices.ExamsDataService;
import com.nzis.ignatovsoft.dataservices.TransactionsDataService;
import com.nzis.ignatovsoft.front.events.TransactionEvent;
import com.nzis.ignatovsoft.front.views.TransactionCellFactory;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MaindashboardController implements Initializable {

    @FXML
    private ListView<ExamDbModel> transactionsList;

    @FXML
    private DatePicker dateFilter;
    public Label selectedPatientName;
    public Label selectedPatientFamilyName;
    public Label examDate;
    public Label phoneNumber;
    public Label diagnosis;
    public Label treatment;
    public Label email;
    public Button cahngeButton;
    private TransactionsDataService testDataService = new TransactionsDataService();
    private ExamsDataService examsDataService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        examsDataService = new ExamsDataService();
        transactionsList.setItems(examsDataService.getAllLocalDbExams());
        transactionsList.setCellFactory(e -> new TransactionCellFactory());
        transactionsList.addEventHandler(TransactionEvent.TRANSACTION_SELECTED, this::handleTransactionEvent);
        cahngeButton.setOnMouseClicked(v -> {
            System.out.println("Not implemented yet");
        });

        dateFilter.valueProperty().addListener((observable, oldValue, newValue) -> {
            filterTransactions(newValue);
        });
    }

    private void filterTransactions(LocalDate date) {
        ObservableList<ExamDbModel> transactions = examsDataService.getFilteredExams(date, LocalDate.now());
        transactionsList.setItems(transactions);
    }

    private void handleTransactionEvent(TransactionEvent event) {
        ExamDbModel transaction = event.getTransaction();
        selectedPatientName.setText(transaction.getPatient().getFirstName());
        selectedPatientFamilyName.setText(transaction.getPatient().getLastName());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String transactionDate = transaction.getCloseDate().format(formatter);
        examDate.setText(transactionDate);

        phoneNumber.setText(transaction.getPatient().getPhone());
        diagnosis.setText(transaction.getDiagnosis().getICDCode());
        treatment.setText(transaction.getDiagnosis().getNotes());
        email.setText(transaction.getExamStatus());
    }
}
