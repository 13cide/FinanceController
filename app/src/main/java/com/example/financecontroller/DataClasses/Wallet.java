package com.example.financecontroller.DataClasses;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity
public class Wallet {

    @NonNull
    public int[] userID;
    @NonNull
    public Currency mainCurrency;
    public int sum;
    @NonNull
    public Account[] accounts;


    public Wallet(@NonNull int[] userID, @NonNull Currency mainCurrency, int sum, @NonNull Account[] accounts) {
        this.userID = userID;
        this.mainCurrency = mainCurrency;
        this.sum = sum;
        this.accounts = accounts;
    }
}
