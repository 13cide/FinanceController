package com.example.financecontroller.DataClasses;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Currency {
    @PrimaryKey
    @NonNull
    public String name;
    public int value;
    @NonNull
    public String symbol;

    public Currency(String name, int value, @NonNull String symbol) {
        this.name = name;
        this.value = value;
        this.symbol = symbol;
    }
}

