package com.pranav.atm;

import java.util.Scanner;

public class ATM {

    private final Scanner scanner = new Scanner(System.in);
    private final User user = new User("pranav", "1234", 10000);

    public void start() {
        System.out.println("================================");
        System.out.println("        WELCOME TO ATM");
        System.out.println("================================");

        if (login()) {
            showMenu();
        } else {
            System.out.println("❌ Invalid credentials. Exiting...");
        }
    }

    private boolean login() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        return user.authenticate(userId, pin);
    }

    private void showMenu() {
        int choice;
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> user.getAccount().showTransactions();
                case 2 -> withdraw();
                case 3 -> deposit();
                case 4 -> transfer();
                case 5 -> System.out.println("Thank you for using ATM!");
                default -> System.out.println("Invalid option!");
            }
        } while (choice != 5);
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        user.getAccount().withdraw(amount);
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        user.getAccount().deposit(amount);
    }

    private void transfer() {
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        user.getAccount().transfer(amount);
    }
}
