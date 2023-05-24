package com.example.financecontroller.DataClasses;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Category implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @NonNull
    public String name;
    public int iconID;
    public boolean isIncome;

    public Category(@NonNull String name, int iconID, boolean isIncome) {
        this.name = name;
        this.iconID = iconID;
        this.isIncome = isIncome;
    }
}
