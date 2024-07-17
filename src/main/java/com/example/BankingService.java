package com.example;

import java.util.HashMap;
import java.util.Map;

public class BankingService {
    private final Map<String, User> users;

    public BankingService() {
        users = new HashMap<>();
    }

    public void register(Username username) {
        users.put(username.getValue(), new User(username));
    }

    public boolean isUsernameTaken(String username) {
        return users.containsKey(username);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public void deposit(User user, double amount) {
        if (user != null) {
            user.deposit(amount);
            System.out.println(ConsoleColors.GREEN + "Deposited: $" + amount + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "User not found." + ConsoleColors.RESET);
        }
    }

    public void withdraw(User user, double amount) {
        if (user != null) {
            try {
                user.withdraw(amount);
                System.out.println(ConsoleColors.GREEN + "Withdrew: $" + amount + ConsoleColors.RESET);
            } catch (IllegalArgumentException e) {
                System.out.println(ConsoleColors.RED + e.getMessage() + ConsoleColors.RESET);
            }
        } else {
            System.out.println(ConsoleColors.RED + "User not found." + ConsoleColors.RESET);
        }
    }

    public void checkBalance(User user) {
        if (user != null) {
            System.out.println(ConsoleColors.CYAN + "Current Balance: $" + user.getBalance().getAmount() + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "User not found." + ConsoleColors.RESET);
        }
    }

    public void viewTransactionHistory(User user) {
        if (user != null) {
            System.out.println(ConsoleColors.CYAN + "Transaction History:" + ConsoleColors.RESET);
            for (Transaction transaction : user.getTransactionHistory()) {
                System.out.println(transaction.getType() + ": $" + transaction.getAmount().getAmount() + " on " + transaction.getTimestamp());
            }
        } else {
            System.out.println(ConsoleColors.RED + "User not found." + ConsoleColors.RESET);
        }
    }
}
