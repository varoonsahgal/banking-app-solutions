package com.example.infrastructure.adapter;

import com.example.application.service.BankingService;

import java.util.Scanner;

public class ConsoleAdapter {
    private final BankingService bankingService;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleAdapter(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    public void run() {
        System.out.println(ConsoleColors.BOLD + ConsoleColors.BLUE + "Welcome to Your Bank!" + ConsoleColors.RESET);
        String choice;
        do {
            displayMenu();
            choice = scanner.nextLine();
            handleUserChoice(choice);
        } while (!choice.equals("7"));

        scanner.close();
    }

    private void displayMenu() {
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

    private void handleUserChoice(String choice) {
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

    private void registerUser() {
        System.out.print(ConsoleColors.BOLD + "Enter username: " + ConsoleColors.RESET);
        String username = scanner.nextLine();
        bankingService.registerUser(username);
    }

    private void selectUser() {
        System.out.print(ConsoleColors.BOLD + "Enter username: " + ConsoleColors.RESET);
        String username = scanner.nextLine();
        bankingService.selectUser(username);
    }

    private void deposit() {
        System.out.print(ConsoleColors.BOLD + "Enter amount to deposit: " + ConsoleColors.RESET);
        double depositAmount = Double.parseDouble(scanner.nextLine());
        bankingService.deposit(depositAmount);
    }

    private void withdraw() {
        System.out.print(ConsoleColors.BOLD + "Enter amount to withdraw: " + ConsoleColors.RESET);
        double withdrawAmount = Double.parseDouble(scanner.nextLine());
        bankingService.withdraw(withdrawAmount);
    }

    private void checkBalance() {
        bankingService.checkBalance();
    }

    private void viewTransactionHistory() {
        bankingService.viewTransactionHistory();
    }
}
