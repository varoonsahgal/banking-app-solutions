package com.example.domain.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final Username username;
    private Balance balance;
    private final List<Transaction> transactionHistory;

    public User(Username username) {
        this.username = username;
        this.balance = new Balance(0);
        this.transactionHistory = new ArrayList<>();
    }

    public Username getUsername() {
        return username;
    }

    public Balance getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance.deposit(amount);
        transactionHistory.add(new Transaction(new Balance(amount), "deposit"));
    }

    public void withdraw(double amount) {
        if (this.balance.canWithdraw(amount)) {
            this.balance.withdraw(amount);
            transactionHistory.add(new Transaction(new Balance(amount), "withdraw"));
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
