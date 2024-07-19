package com.nzis.ignatovsoft.front.events;

import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import javafx.event.Event;
import javafx.event.EventType;

public class TransactionEvent extends Event {
    public static final EventType<TransactionEvent> TRANSACTION_SELECTED = new EventType<>(Event.ANY, "TRANSACTION_SELECTED");

    private final ExamDbModel transaction;

    public TransactionEvent(ExamDbModel transaction) {
        super(TRANSACTION_SELECTED);
        this.transaction = transaction;
    }

    public ExamDbModel getTransaction() {
        return transaction;
    }
}