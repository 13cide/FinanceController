package com.example.financecontroller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.financecontroller.Adapters.AddTransactionCategoryAdapter;
import com.example.financecontroller.Adapters.CategoryAdapter;
import com.example.financecontroller.DataClasses.Category;
import com.example.financecontroller.DataClasses.Transaction;
import com.example.financecontroller.Room.DatabaseDAO;
import com.example.financecontroller.databinding.ActivityAddTransactionBinding;
import com.google.android.material.color.DynamicColors;

import java.util.ArrayList;
import java.util.List;

public class AddTransactionActivity extends AppCompatActivity {

    ActivityAddTransactionBinding binding;

    List<Category> incomeList = new ArrayList<>();
    List<Category> spendList = new ArrayList<>();
    List<Category> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DynamicColors.applyToActivityIfAvailable(this);
        binding = ActivityAddTransactionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DatabaseDAO dao = App.getDatabase().DAO();

        new Thread(() -> {
            incomeList.addAll(dao.getIncomeCategories());
            spendList.addAll(dao.getSpendCategories());
            list.addAll(incomeList);
        }).start();


        binding.categorylist.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.categorylist.setAdapter(new AddTransactionCategoryAdapter(list, this));

        binding.switcher.setOnClickListener(view -> {
            binding.switcher.setText(!binding.switcher.isChecked() ? "Доход" : "Трата");
            list.clear();
            list.addAll(!binding.switcher.isChecked() ? incomeList : spendList);
            binding.categorylist.getAdapter().notifyDataSetChanged();
        });

        binding.addButton.setOnClickListener(view -> {
            if (!binding.amount.getText().toString().isEmpty()) {
                int amount = Integer.parseInt(binding.amount.getText().toString());
                int categoryID = list.get(((AddTransactionCategoryAdapter)binding.categorylist.getAdapter()).choosenID).id;


                Transaction transaction = new Transaction(amount, null, "₽", categoryID);

                Intent intent = new Intent();
                intent.putExtra("isIncome", !binding.switcher.isChecked());
                intent.putExtra("transaction", transaction);
                setResult(RESULT_OK, intent);


                finish();
            } else {
                Toast.makeText(this, "Необходимо ввести сумму", Toast.LENGTH_SHORT).show();
            }
        });
    }
}