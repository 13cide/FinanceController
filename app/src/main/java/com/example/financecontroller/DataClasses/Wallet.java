package com.example.financecontroller.DataClasses;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Wallet {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public int currency;
    public int sum;

    public Wallet(int id, int currency, int sum) {
        this.id = id;
        this.currency = currency;
        this.sum = sum;
    }
}
