package com.example.financecontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.widget.Toast;

import com.example.financecontroller.DataClasses.Localdb;
import com.example.financecontroller.DataClasses.Transaction;
import com.example.financecontroller.Fragments.TransactionsFragment;
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

                Localdb db = MainActivity.db;

                if (binding.switcher.isChecked())
                    db.account.getSpends().add(new Transaction(db.nextTransactionID(),
                            db.music, amount, 1, "", "₽"));
                else db.account.getIncomes().add(new Transaction(db.nextTransactionID(),
                        db.salary, amount, 1, "", "₽"));
                db.wallet.setSum(db.wallet.getSum() + amount * (binding.switcher.isChecked() ? -1 : 1));
                MainActivity.db = db;
                finish();
            }
            else {
                Toast.makeText(this, "Необходимо ввести сумму", Toast.LENGTH_SHORT).show();
            }
        });

    }
}