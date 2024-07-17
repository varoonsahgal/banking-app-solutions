package com.example;

import com.example.application.service.BankingService;
import com.example.infrastructure.adapter.ConsoleAdapter;

public class BankingApplication {
    public static void main(String[] args) {
        BankingService bankingService = new BankingService();
        ConsoleAdapter consoleAdapter = new ConsoleAdapter(bankingService);
        consoleAdapter.run();
    }
}
