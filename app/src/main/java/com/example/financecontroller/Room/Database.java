package com.example.financecontroller.Room;

import androidx.room.RoomDatabase;

import com.example.financecontroller.DataClasses.Account;
import com.example.financecontroller.DataClasses.Category;
import com.example.financecontroller.DataClasses.Currency;
import com.example.financecontroller.DataClasses.Transaction;
import com.example.financecontroller.DataClasses.Wallet;

@androidx.room.Database(entities = {Transaction.class, Account.class, Category.class, Currency.class, Wallet.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract TransactionDAO transactionDAO();
    public abstract AccountDAO accountDAO();
    public abstract CategoryDAO categoryDAO();
    public abstract CurrencyDAO currencyDAO();
    public abstract WalletDAO walletDAO();
}
