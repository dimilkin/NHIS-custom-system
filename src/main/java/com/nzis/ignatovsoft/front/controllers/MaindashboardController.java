package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.front.events.TransactionEvent;
import com.nzis.ignatovsoft.front.models.Transaction;
import com.nzis.ignatovsoft.front.views.TransactionCellFactory;
import com.nzis.ignatovsoft.nhis.services.TestDataService;
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
    private ListView<Transaction> transactionsList;

    @FXML
    private DatePicker dateFilter;
    ;


    public Label selectedPatientName;
    public Label selectedPatientFamilyName;
    public Label examDate;
    public Label phoneNumber;
    public Label diagnosis;
    public Label treatment;
    public Label email;
    public Button change_btn;
    private TestDataService testDataService = new TestDataService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transactionsList.setItems(testDataService.getAllTransactions());
        transactionsList.setCellFactory(e -> new TransactionCellFactory());
        transactionsList.addEventHandler(TransactionEvent.TRANSACTION_SELECTED, this::handleTransactionEvent);
        change_btn.setOnMouseClicked(v -> {
            System.out.println("Not implemented yet");
        });

        dateFilter.valueProperty().addListener((observable, oldValue, newValue) -> {
            filterTransactions(newValue);
        });
    }

    private void filterTransactions(LocalDate date) {
        ObservableList<Transaction> transactions = testDataService.getAllTransactions();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        ObservableList<Transaction> filteredTransactions = transactions.filtered(transaction -> {
            LocalDate examDate = LocalDate.parse(transaction.getDateOfExam(), formatter);
            return examDate.equals(date);
        });
        transactionsList.setItems(filteredTransactions);
    }

    private void handleTransactionEvent(TransactionEvent event) {
        Transaction transaction = event.getTransaction();
        selectedPatientName.setText(transaction.getName());
        selectedPatientFamilyName.setText(transaction.getFamilyName());
        examDate.setText(transaction.getDateOfExam());
        phoneNumber.setText(transaction.getPhone());
        diagnosis.setText(transaction.getDiagnosis());
        treatment.setText(transaction.getProcedure());
        email.setText(transaction.getAddress());
    }
}
