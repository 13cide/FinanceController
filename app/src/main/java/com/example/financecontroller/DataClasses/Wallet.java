package com.example.financecontroller.DataClasses;

public class Wallet {

    private int[] userID;
    private int sum;
    private Account[] accounts;

    public Wallet(int[] userID, int sum, Account[] accounts) {
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

    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }

    public Account[] getAccounts() {
        return accounts;
    }
    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }
}
