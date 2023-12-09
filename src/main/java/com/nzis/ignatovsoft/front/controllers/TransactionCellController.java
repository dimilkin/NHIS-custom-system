package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.front.models.Transaction;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionCellController implements Initializable {
    public Label transaction_cell_first_name;
    public Label transaction_cell_family_name;
    public Label transaction_cell_time;
    public Label transaction_cell_date;
    public Line transaction_cell_line_one;
    public Line transaction_cell_line_two;
    public AnchorPane transactionCellPane;

    private final Transaction transaction;

    public TransactionCellController(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (!transaction.isTransactionSuccesful()){
            transactionCellPane.setStyle("-fx-border-color: RED;");
        }
        transaction_cell_first_name.setText(transaction.getName());
        transaction_cell_family_name.setText(transaction.getFamilyName());
        transaction_cell_date.setText(transaction.getDateOfExam());
        transaction_cell_time.setText(transaction.getTimeOfExam());
    }

}
