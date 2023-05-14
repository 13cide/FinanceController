package com.example.financecontroller.Room;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.financecontroller.DataClasses.Category;

@Dao
public interface CategoryDAO {

    @Insert
    void save(Category category);

}
