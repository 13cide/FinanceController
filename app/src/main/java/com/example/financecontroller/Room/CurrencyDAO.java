package com.example.financecontroller.Room;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.financecontroller.DataClasses.Currency;

@Dao
public interface CurrencyDAO {

    @Insert
    void save(Currency currency);
}
