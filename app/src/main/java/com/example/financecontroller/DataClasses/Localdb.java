package com.example.financecontroller.DataClasses;

import com.example.financecontroller.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Localdb {
    private int current_id = 0;

    public Currency ruble = new Currency("RUB", 1, "₽");
    public Currency dollar = new Currency("USD", 75.46, "$");
    public Currency lira = new Currency("TRY", 4, "₺");
    public Currency euro = new Currency("EUR", 80.05, "€");
    public Currency tenge = new Currency("KZT", 0.1732, "₸");
    public Currency yuan = new Currency("CNY", 10.91, "¥");
    public Currency belarus_ruble = new Currency("BYN", 26.64, "Br");


    public final Category music = new Category(1, "music", android.R.color.holo_red_dark, R.drawable.icon_guitars, false);
    public final Category salary = new Category(2, "salary", android.R.color.holo_green_dark, R.drawable.icon_salary, true);
    public final Transaction transaction = new Transaction(nextTransactionID(), salary, 500, 1, "sosi", "₽");
    public final Transaction transaction2 = new Transaction(nextTransactionID(), music, 500, 1, "sosi", "₽");


    public Account account = new Account(1, ruble, 10000,
            new ArrayList<Transaction>(Arrays.asList(transaction2, transaction2, transaction2)),
            new ArrayList<Transaction>(Arrays.asList(transaction, transaction, transaction, transaction)));

    public Wallet wallet = new Wallet(new int[]{1}, 10000, new Account[]{account});

    public int nextTransactionID() {
        return current_id++;
    }
}
