package com.example.domain.model;

import java.math.BigDecimal;

public class Balance {
    private BigDecimal amount;

    public Balance(double amount) {
        this.amount = BigDecimal.valueOf(amount).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
        this.amount = this.amount.add(BigDecimal.valueOf(amount));
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount cannot be negative");
        }
        BigDecimal newAmount = this.amount.subtract(BigDecimal.valueOf(amount));
        if (newAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Insufficient funds for this withdrawal");
        }
        this.amount = newAmount;
    }

    public boolean canWithdraw(double amount) {
        return this.amount.compareTo(BigDecimal.valueOf(amount)) >= 0;
    }
}
