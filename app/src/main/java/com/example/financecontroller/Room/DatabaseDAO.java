package com.example.financecontroller.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.financecontroller.DataClasses.Category;
import com.example.financecontroller.DataClasses.Currency;
import com.example.financecontroller.DataClasses.Transaction;

import java.util.List;

@Dao
public interface DatabaseDAO {

    @Insert
    void save(Transaction transaction);
    @Insert
    void save(Category category);
    @Insert
    void save(Currency currency);

    @Query("SELECT * FROM `Transaction` " +
            "INNER JOIN Category ON `Transaction`.categoryId = Category.id " +
            "WHERE Category.isIncome = 0")
    List<Transaction> getSpends();

    @Query("SELECT * FROM `Transaction` " +
            "INNER JOIN Category ON `Transaction`.categoryId = Category.id " +
            "WHERE Category.isIncome = 1")
    List<Transaction> getIncomes();

    @Query("SELECT * FROM Category WHERE Category.isIncome = 1")
    List<Category> getIncomeCategories();

    @Query("SELECT * FROM Category WHERE Category.isIncome = 0")
    List<Category> getSpendCategories();

    @Query("SELECT * FROM Currency")
    List<Currency> getCurrencies();

    @Query("DELETE FROM `Transaction`")
    void del1();

    @Query("DELETE FROM Category")
    void del2();

}
