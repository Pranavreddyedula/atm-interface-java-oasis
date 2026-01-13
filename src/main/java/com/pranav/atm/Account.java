package com.pranav.atm;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private double balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
            System.out.println("✅ Deposit successful. Balance: " + balance);
        } else {
            System.out.println("❌ Invalid amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount));
            System.out.println("✅ Withdrawal successful. Balance: " + balance);
        } else {
            System.out.println("❌ Insufficient balance");
        }
    }

    public void transfer(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Transfer", amount));
            System.out.println("✅ Transfer successful. Balance: " + balance);
        } else {
            System.out.println("❌ Transfer failed");
        }
    }

    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("\n--- Transaction History ---");
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }
}
