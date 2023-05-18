package com.example.financecontroller.Room;

import androidx.room.RoomDatabase;

import com.example.financecontroller.DataClasses.Account;
import com.example.financecontroller.DataClasses.Category;
import com.example.financecontroller.DataClasses.Currency;
import com.example.financecontroller.DataClasses.Transaction;

@androidx.room.Database(entities = {Transaction.class, Account.class, Category.class, Currency.class}, version = 2)
public abstract class Database extends RoomDatabase {
    public abstract DatabaseDAO DAO();

}
