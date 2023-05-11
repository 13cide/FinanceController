package com.example.financecontroller.DataClasses;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Category {
    @PrimaryKey(autoGenerate = true)
    public int categoryID;
    @NonNull
    public String name;
    public int colorID;
    public int iconID;
    public boolean isIncome;

    public Category(int categoryID, @NonNull String name, int colorID, int iconID, boolean isIncome) {
        this.categoryID = categoryID;
        this.name = name;
        this.colorID = colorID;
        this.iconID = iconID;
        this.isIncome = isIncome;
    }
}
