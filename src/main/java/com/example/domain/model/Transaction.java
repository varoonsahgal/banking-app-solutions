package com.example.domain.model;

import java.time.LocalDateTime;

public class Transaction {
    private final Balance amount;
    private final LocalDateTime timestamp;
    private final String type;

    public Transaction(Balance amount, String type) {
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.type = type;
    }

    public Balance getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }
}
