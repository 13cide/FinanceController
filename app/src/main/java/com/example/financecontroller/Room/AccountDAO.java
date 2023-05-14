package com.example.financecontroller.Room;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.financecontroller.DataClasses.Account;

@Dao
public interface AccountDAO {

    @Insert
    void save(Account account);

}
