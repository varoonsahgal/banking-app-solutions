package com.example.application.service;

import com.example.domain.model.Transaction;
import com.example.domain.model.User;
import com.example.domain.model.Username;

public class BankingService {
    private User currentUser;

    public void registerUser(String username) {
        Username uname = new Username(username);
        User user = new User(uname);
        this.currentUser = user; // For simplicity, set the registered user as the current user
        System.out.println("User registered successfully.");
    }

    public void selectUser(String username) {
        Username uname = new Username(username);
        this.currentUser = new User(uname); // For simplicity, simulate user retrieval
        System.out.println("User selected: " + username);
    }

    public void deposit(double amount) {
        if (currentUser != null) {
            currentUser.deposit(amount);
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("No user selected.");
        }
    }

    public void withdraw(double amount) {
        if (currentUser != null) {
            try {
                currentUser.withdraw(amount);
                System.out.println("Withdrew: $" + amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("No user selected.");
        }
    }

    public void checkBalance() {
        if (currentUser != null) {
            System.out.println("Current Balance: $" + currentUser.getBalance().getAmount());
        } else {
            System.out.println("No user selected.");
        }
    }

    public void viewTransactionHistory() {
        if (currentUser != null) {
            System.out.println("Transaction History:");
            for (Transaction transaction : currentUser.getTransactionHistory()) {
                System.out.println(transaction.getType() + ": $" + transaction.getAmount().getAmount() + " on " + transaction.getTimestamp());
            }
        } else {
            System.out.println("No user selected.");
        }
    }
}
