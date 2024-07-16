package com.example;

import java.util.Scanner;

public class BankingApplication {
    private static BankingService bank = new BankingService();
    private static Scanner scanner = new Scanner(System.in);
    private static User currentUser = null;

    public static void main(String[] args) {
        System.out.println(ConsoleColors.BOLD + ConsoleColors.BLUE + "Welcome to Your Bank!" + ConsoleColors.RESET);
        String choice;
        do {
            choice = displayMenu();
        } while (!choice.equals("7"));

        scanner.close();
    }

    private static String displayMenu() {
        System.out.println(ConsoleColors.BOLD + ConsoleColors.YELLOW + "\nMenu" + ConsoleColors.RESET);
        System.out.println("1. Register");
        System.out.println("2. Select User");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Check Balance");
        System.out.println("6. View Transaction History");
        System.out.println("7. Exit");
        System.out.print(ConsoleColors.BOLD + "Enter your choice: " + ConsoleColors.RESET);

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                registerUser();
                break;
            case "2":
                selectUser();
                break;
            case "3":
                deposit();
                break;
            case "4":
                withdraw();
                break;
            case "5":
                checkBalance();
                break;
            case "6":
                viewTransactionHistory();
                break;
            case "7":
                System.out.println(ConsoleColors.GREEN + "Thank you for banking with us!" + ConsoleColors.RESET);
                break;
            default:
                System.out.println(ConsoleColors.RED + "Invalid choice. Please try again." + ConsoleColors.RESET);
        }

        return choice;
    }

    private static void registerUser() {
        System.out.print(ConsoleColors.BOLD + "Enter username: " + ConsoleColors.RESET);
        String username = scanner.nextLine();
        if (!bank.isUsernameTaken(username)) {
            bank.register(username);
            System.out.println(ConsoleColors.GREEN + "User registered successfully." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "Username already taken." + ConsoleColors.RESET);
        }
    }

    private static void selectUser() {
        System.out.print(ConsoleColors.BOLD + "Enter username: " + ConsoleColors.RESET);
        String username = scanner.nextLine();
        currentUser = bank.getUser(username);
        if (currentUser != null) {
            System.out.println(ConsoleColors.GREEN + "User selected: " + username + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "User not found." + ConsoleColors.RESET);
        }
    }

    private static void deposit() {
        if (currentUser != null) {
            System.out.print(ConsoleColors.BOLD + "Enter amount to deposit: " + ConsoleColors.RESET);
            double depositAmount = Double.parseDouble(scanner.nextLine());
            if (depositAmount > 0) {
                currentUser.deposit(depositAmount);
                System.out.println(ConsoleColors.GREEN + "Deposited: $" + depositAmount + ConsoleColors.RESET);
            } else {
                System.out.println(ConsoleColors.RED + "Invalid deposit amount." + ConsoleColors.RESET);
            }
        } else {
            System.out.println(ConsoleColors.RED + "No user selected." + ConsoleColors.RESET);
        }
    }

    private static void withdraw() {
        if (currentUser != null) {
            System.out.print(ConsoleColors.BOLD + "Enter amount to withdraw: " + ConsoleColors.RESET);
            double withdrawAmount = Double.parseDouble(scanner.nextLine());
            if (withdrawAmount > 0) {
                if (currentUser.getBalance() >= withdrawAmount) {
                    currentUser.withdraw(withdrawAmount);
                    System.out.println(ConsoleColors.GREEN + "Withdrew: $" + withdrawAmount + ConsoleColors.RESET);
                } else {
                    System.out.println(ConsoleColors.RED + "Insufficient funds." + ConsoleColors.RESET);
                }
            } else {
                System.out.println(ConsoleColors.RED + "Invalid withdrawal amount." + ConsoleColors.RESET);
            }
        } else {
            System.out.println(ConsoleColors.RED + "No user selected." + ConsoleColors.RESET);
        }
    }

    private static void checkBalance() {
        if (currentUser != null) {
            System.out.println(ConsoleColors.CYAN + "Current Balance: $" + currentUser.getBalance() + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "No user selected." + ConsoleColors.RESET);
        }
    }

    private static void viewTransactionHistory() {
        if (currentUser != null) {
            System.out.println(ConsoleColors.CYAN + "Transaction History:" + ConsoleColors.RESET);
            for (String transaction : currentUser.getTransactionHistory()) {
                System.out.println(transaction);
            }
        } else {
            System.out.println(ConsoleColors.RED + "No user selected." + ConsoleColors.RESET);
        }
    }
}
