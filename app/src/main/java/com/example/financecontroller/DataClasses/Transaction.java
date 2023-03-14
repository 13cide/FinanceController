package com.example.financecontroller.DataClasses;

public class Transaction {
    private int transactionID;
    private Category category;
    private int value;
    private int userID;
    private String description;
    private final String currency_symbol;
    private final long date = System.currentTimeMillis();

    public Transaction(int transactionID, Category category, int value, int userID, String description, String currency_symbol) {
        this.transactionID = transactionID;
        this.category = category;
        this.value = value;
        this.userID = userID;
        this.description = description;
        this.currency_symbol = currency_symbol;
    }

    public Category getCategory() {
        return category;
    }

    public int getValue() {
        return value;
    }

    public long getDate() {
        return date;
    }

    public String getCurrency_symbol() {
        return currency_symbol;
    }
}
