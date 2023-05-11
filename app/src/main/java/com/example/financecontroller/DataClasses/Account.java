package com.example.financecontroller.DataClasses;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Account {
    @PrimaryKey(autoGenerate = true)
    public int accountID;
    @NonNull
    public Currency currency;
    public int sum;
    @NonNull
    public ArrayList<Transaction> spends;
    @NonNull
    public ArrayList<Transaction> incomes;


    public Account(int accountID, @NonNull Currency currency, int sum, @NonNull ArrayList<Transaction> spends, @NonNull ArrayList<Transaction> incomes) {
        this.accountID = accountID;
        this.currency = currency;
        this.sum = sum;
        this.spends = spends;
        this.incomes = incomes;
    }
}
