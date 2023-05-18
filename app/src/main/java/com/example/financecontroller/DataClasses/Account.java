package com.example.financecontroller.DataClasses;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Account {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int walletID;
    @NonNull
    public String currency;
    public int sum;

    public Account(int id, int walletID, @NonNull String currency, int sum) {
        this.id = id;
        this.walletID = walletID;
        this.currency = currency;
        this.sum = sum;
    }
}
