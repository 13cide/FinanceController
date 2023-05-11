package com.example.financecontroller.DataClasses;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public Category category;
    public int value;
    public int userID;
    public String description;
    @NonNull
    public final String currency_symbol;

    public final long date = System.currentTimeMillis();

    public Transaction(int id, @NonNull Category category, int value, int userID, String description, @NonNull String currency_symbol) {
        this.id = id;
        this.category = category;
        this.value = value;
        this.userID = userID;
        this.description = description;
        this.currency_symbol = currency_symbol;
    }
}
