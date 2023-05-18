package com.example.financecontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.financecontroller.DataClasses.Transaction;
import com.example.financecontroller.databinding.ActivityAddTransactionBinding;
import com.google.android.material.color.DynamicColors;

import java.util.ArrayList;
import java.util.List;

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


                Transaction transaction = new Transaction(amount, null, "₽", !binding.switcher.isChecked() ? 1 : 0);

                Intent intent = new Intent();
                intent.putExtra("isIncome", !binding.switcher.isChecked());
                intent.putExtra("transaction", transaction);
                setResult(RESULT_OK, intent);



                finish();
            }
            else {
                Toast.makeText(this, "Необходимо ввести сумму", Toast.LENGTH_SHORT).show();
            }
        });

    }
}