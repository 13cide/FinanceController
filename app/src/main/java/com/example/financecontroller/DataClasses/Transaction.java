package com.example.financecontroller.DataClasses;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Transaction implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int value;
    public String description;
    @NonNull
    public String currency;

    public int categoryID;

    public long date = System.currentTimeMillis();

    public Transaction( int value, String description, @NonNull String currency, int categoryID) {
        this.value = value;
        this.description = description;
        this.currency = currency;
        this.categoryID = categoryID;
    }
}
