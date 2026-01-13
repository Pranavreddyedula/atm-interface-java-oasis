package com.pranav.atm;

public class User {

    private final String userId;
    private final String pin;
    private final Account account;

    public User(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.account = new Account(balance);
    }

    public boolean authenticate(String id, String enteredPin) {
        return userId.equals(id) && pin.equals(enteredPin);
    }

    public Account getAccount() {
        return account;
    }
}
