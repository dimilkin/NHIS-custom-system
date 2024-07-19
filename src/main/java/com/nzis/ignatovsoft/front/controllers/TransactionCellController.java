package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TransactionCellController implements Initializable {
    public Label transaction_cell_first_name;
    public Label transaction_cell_family_name;
    public Label transaction_cell_time;
    public Label transaction_cell_date;
    public Line transaction_cell_line_one;
    public Line transaction_cell_line_two;
    public AnchorPane transactionCellPane;

    private final ExamDbModel transaction;

    public TransactionCellController(ExamDbModel transaction) {
        this.transaction = transaction;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (transaction.getExamNHISStatusCode() != 200){
            transactionCellPane.setStyle("-fx-border-color: RED;");
        }
        transaction_cell_first_name.setText(transaction.getPatient().getFirstName());
        transaction_cell_family_name.setText(transaction.getPatient().getLastName());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String transactionDate = transaction.getCloseDate().format(formatter);

        DateTimeFormatter timeFormater = DateTimeFormatter.ofPattern("HH:mm:ss");
        String transactionTime = transaction.getCloseDate().format(timeFormater);

        transaction_cell_date.setText(transactionDate);
        transaction_cell_time.setText(transactionTime);
    }

}
