package com.example.financecontroller.DataClasses;

public class Wallet {

    private int[] userID;
    private double sum;
    private Account[] accounts;

    public Wallet(int[] userID, double sum, Account[] accounts) {
        this.userID = userID;
        this.sum = sum;
        this.accounts = accounts;
    }


    public int[] getUserID() {
        return userID;
    }
    public void setUserID(int[] userID) {
        this.userID = userID;
    }

    public double getSum() {
        return sum;
    }
    public void setSum(double sum) {
        this.sum = sum;
    }

    public Account[] getAccounts() {
        return accounts;
    }
    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }
}
