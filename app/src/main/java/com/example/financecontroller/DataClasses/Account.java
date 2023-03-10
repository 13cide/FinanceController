package com.example.financecontroller.DataClasses;

import java.util.ArrayList;

public class Account {
    private int accountID;
    private Currency currency;
    private double sum;
    private ArrayList<Transaction> spends;
    private ArrayList<Transaction> incomes;


    public Account(int accountID, Currency currency, double sum, ArrayList<Transaction> spends, ArrayList<Transaction> incomes) {
        this.accountID = accountID;
        this.currency = currency;
        this.sum = sum;
        this.spends = spends;
        this.incomes = incomes;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public ArrayList<Transaction> getSpends() {
        return spends;
    }

    public void setSpends(ArrayList<Transaction> spends) {
        this.spends = spends;
    }

    public ArrayList<Transaction> getIncomes() {
        return incomes;
    }

    public void setIncomes(ArrayList<Transaction> incomes) {
        this.incomes = incomes;
    }
}
