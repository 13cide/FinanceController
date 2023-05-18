package com.example.financecontroller;

import android.app.Application;

import androidx.room.Room;

import com.example.financecontroller.Room.Database;

public class App extends Application {
    private static Database database;

    public static Database getDatabase() {
        return database;
    }

    @Override
    public void onCreate() {
        database = Room.databaseBuilder(this, Database.class, "database").fallbackToDestructiveMigration().build();
        super.onCreate();
    }
}
