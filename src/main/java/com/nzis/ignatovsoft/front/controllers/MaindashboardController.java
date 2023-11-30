package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.front.models.Transaction;
import com.nzis.ignatovsoft.front.views.TransactionCellFactory;
import com.nzis.ignatovsoft.services.TestDataService;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class MaindashboardController implements Initializable {
    public ListView<Transaction> transactionsList;
    private TestDataService testDataService = new TestDataService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transactionsList.setItems(testDataService.getAllTransactions());
        transactionsList.setCellFactory(e -> new TransactionCellFactory());
    }
}
