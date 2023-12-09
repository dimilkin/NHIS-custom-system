package com.nzis.ignatovsoft.front.events;

import com.nzis.ignatovsoft.front.models.Transaction;
import javafx.event.Event;
import javafx.event.EventType;

public class TransactionEvent extends Event {
    public static final EventType<TransactionEvent> TRANSACTION_SELECTED = new EventType<>(Event.ANY, "TRANSACTION_SELECTED");

    private final Transaction transaction;

    public TransactionEvent(Transaction transaction) {
        super(TRANSACTION_SELECTED);
        this.transaction = transaction;
    }

    public Transaction getTransaction() {
        return transaction;
    }
}