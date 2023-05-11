package com.example.financecontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.financecontroller.DataClasses.Transaction;
import com.example.financecontroller.DataClasses.Wallet;
import com.example.financecontroller.Room.Database;
import com.example.financecontroller.databinding.ActivityAddTransactionBinding;
import com.google.android.material.color.DynamicColors;

public class AddTransactionActivity extends AppCompatActivity {

    ActivityAddTransactionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DynamicColors.applyToActivityIfAvailable(this);
        binding = ActivityAddTransactionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.switcher.setOnClickListener(view -> {
            binding.switcher.setText(binding.switcher.isChecked() ? "Трата" : "Доход");
        });

        binding.addButton.setOnClickListener(view -> {
            if (!binding.amount.getText().toString().isEmpty()) {
                int amount = Integer.parseInt(binding.amount.getText().toString());

                Wallet wallet = App.getDatabase().walletDAO().getAll().get(0);

//                if (binding.switcher.isChecked())
//                    database.account.getSpends().add(new Transaction(database.nextTransactionID(),
//                            database.music, amount, 1, "", "₽"));
//
//                else database.account.getIncomes().add(new Transaction(database.nextTransactionID(),
//                        database.salary, amount, 1, "", "₽"));
//
//                database.walletDAO().wallet.setSum(database.wallet.getSum() + amount * (binding.switcher.isChecked() ? -1 : 1));
//                MainActivity.db = db;
                finish();
            }
            else {
                Toast.makeText(this, "Необходимо ввести сумму", Toast.LENGTH_SHORT).show();
            }
        });

    }
}