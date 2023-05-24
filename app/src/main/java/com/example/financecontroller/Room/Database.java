package com.example.financecontroller.Room;

import androidx.room.RoomDatabase;

import com.example.financecontroller.DataClasses.Category;
import com.example.financecontroller.DataClasses.Currency;
import com.example.financecontroller.DataClasses.Transaction;

@androidx.room.Database(entities = {Transaction.class, Category.class, Currency.class}, version = 3)
public abstract class Database extends RoomDatabase {
    public abstract DatabaseDAO DAO();

}
