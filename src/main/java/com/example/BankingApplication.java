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
            displayMenu();
            choice = getUserChoice();
            handleUserChoice(choice);
        } while (!choice.equals("7"));

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println(ConsoleColors.BOLD + ConsoleColors.YELLOW + "\nMenu" + ConsoleColors.RESET);
        System.out.println("1. Register");
        System.out.println("2. Select User");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Check Balance");
        System.out.println("6. View Transaction History");
        System.out.println("7. Exit");
        System.out.print(ConsoleColors.BOLD + "Enter your choice: " + ConsoleColors.RESET);
    }

    private static String getUserChoice() {
        return scanner.nextLine();
    }

    private static void handleUserChoice(String choice) {
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
    }

    private static void registerUser() {
        System.out.print(ConsoleColors.BOLD + "Enter username: " + ConsoleColors.RESET);
        String username = scanner.nextLine();
        if (!bank.isUsernameTaken(username)) {
            bank.register(new Username(username));
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
            bank.deposit(currentUser, depositAmount);
        } else {
            System.out.println(ConsoleColors.RED + "No user selected." + ConsoleColors.RESET);
        }
    }

    private static void withdraw() {
        if (currentUser != null) {
            System.out.print(ConsoleColors.BOLD + "Enter amount to withdraw: " + ConsoleColors.RESET);
            double withdrawAmount = Double.parseDouble(scanner.nextLine());
            bank.withdraw(currentUser, withdrawAmount);
        } else {
            System.out.println(ConsoleColors.RED + "No user selected." + ConsoleColors.RESET);
        }
    }

    private static void checkBalance() {
        if (currentUser != null) {
            bank.checkBalance(currentUser);
        } else {
            System.out.println(ConsoleColors.RED + "No user selected." + ConsoleColors.RESET);
        }
    }

    private static void viewTransactionHistory() {
        if (currentUser != null) {
            bank.viewTransactionHistory(currentUser);
        } else {
            System.out.println(ConsoleColors.RED + "No user selected." + ConsoleColors.RESET);
        }
    }
}
