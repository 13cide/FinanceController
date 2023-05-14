package com.example.financecontroller.DataClasses;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int value;
    @NonNull
    public String description;
    @NonNull
    public String currency;

    public int categoryID;

    public long date = System.currentTimeMillis();

    public Transaction(int id, int value, @NonNull String description, @NonNull String currency, int categoryID, long date) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.currency = currency;
        this.categoryID = categoryID;
        this.date = date;
    }
}
