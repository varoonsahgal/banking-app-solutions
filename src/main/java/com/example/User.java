package com.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private double balance;
    private List<String> transactionHistory;

    public User(String username) {
        this.username = username;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: $" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
        }
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}
