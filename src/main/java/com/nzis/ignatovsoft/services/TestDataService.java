package com.nzis.ignatovsoft.services;

import com.nzis.ignatovsoft.front.models.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TestDataService {

    private final ObservableList<Transaction> allTransactions = FXCollections.observableArrayList();

    public TestDataService() {
        loadData();
    }

    public ObservableList<Transaction> getAllTransactions() {
        return allTransactions;
    }

    private void loadData() {
        Transaction t1 = new Transaction("Dimi", "00222");
        Transaction t2 = new Transaction("Dimi", "00222");
        Transaction t3 = new Transaction("Dimi", "00222");
        Transaction t4 = new Transaction("Dimi", "00222");
        Transaction t5 = new Transaction("Dimi", "00222");
        Transaction t6 = new Transaction("Dimi", "00222");
        allTransactions.addAll(t1, t2,t3,t4,t5,t6);
    }
}
