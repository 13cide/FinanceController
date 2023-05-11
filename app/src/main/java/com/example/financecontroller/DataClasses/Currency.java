package com.example.financecontroller.DataClasses;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Currency {
    @PrimaryKey
    public String name;
    public double value;
    @NonNull
    public final String symbol;

    public Currency(@NonNull String name, double value, @NonNull String symbol) {
        this.name = name;
        this.value = value;
        this.symbol = symbol;
    }

}

