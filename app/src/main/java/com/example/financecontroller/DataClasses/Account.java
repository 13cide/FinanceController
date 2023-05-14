package com.example.financecontroller.DataClasses;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Account {
    @PrimaryKey(autoGenerate = true)
    public int accountID;
    public int walletID;
    @NonNull
    public String currency;
    public int sum;

    public Account(int accountID, int walletID, @NonNull String currency, int sum) {
        this.accountID = accountID;
        this.walletID = walletID;
        this.currency = currency;
        this.sum = sum;
    }
}
