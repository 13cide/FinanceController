package com.example.financecontroller.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.financecontroller.DataClasses.Wallet;

import java.util.List;

@Dao
public interface WalletDAO {

    @Insert
    void save(Wallet wallet);

    @Query("SELECT * FROM Wallet")
    List<Wallet> getAll();
}
