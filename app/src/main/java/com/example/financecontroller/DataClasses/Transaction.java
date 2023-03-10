package com.example.financecontroller.DataClasses;

public class Transaction {
    private int transactionID;
    private Category category;
    private double value;
    private int userID;
    private String description;
    private final String Currency_symbol;
    private final long date = System.currentTimeMillis();

    public Transaction(int transactionID, Category category, double value, int userID, String description, String currency_symbol) {
        this.transactionID = transactionID;
        this.category = category;
        this.value = value;
        this.userID = userID;
        this.description = description;
        Currency_symbol = currency_symbol;
    }

    public int getTransactionID() {
        return transactionID;
    }
    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public long getDate() {
        return date;
    }

    public String getCurrency_symbol() {
        return Currency_symbol;
    }
}
