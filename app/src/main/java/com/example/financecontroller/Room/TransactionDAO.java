package com.example.financecontroller.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.financecontroller.DataClasses.Transaction;

import java.util.List;

@Dao
public interface TransactionDAO {
    @Insert
    void save(Transaction transaction);

    @Query("SELECT * FROM 'Transaction'")
    List<Transaction> getAll();

    @Query("SELECT * FROM `Transaction` WHERE id = :id")
    Transaction getId(int id);
}
