package com.example.financecontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.GameManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.financecontroller.Adapters.AddTransactionCategoryAdapter;
import com.example.financecontroller.Adapters.IconsAdapter;
import com.example.financecontroller.DataClasses.Category;
import com.example.financecontroller.DataClasses.Transaction;
import com.example.financecontroller.databinding.ActivityAddCategoryBinding;
import com.example.financecontroller.databinding.ActivityAddTransactionBinding;
import com.google.android.material.color.DynamicColors;

public class AddCategoryActivity extends AppCompatActivity {

    ActivityAddCategoryBinding binding;
    int[] icons = {R.drawable.icon_guitars, R.drawable.icon_salary, R.drawable.icon_cafe, R.drawable.icon_chilling, R.drawable.icon_education,
        R.drawable.icon_else, R.drawable.icon_family, R.drawable.icon_gift, R.drawable.icon_health, R.drawable.icon_home, R.drawable.icon_percents,
        R.drawable.icon_products, R.drawable.icon_education, R.drawable.icon_sport, R.drawable.icon_1, R.drawable.icon_2, R.drawable.icon_3,
        R.drawable.icon_4, R.drawable.icon_5, R.drawable.icon_6, R.drawable.icon_7, R.drawable.icon_8, R.drawable.icon_9, R.drawable.icon_10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DynamicColors.applyToActivityIfAvailable(this);
        binding = ActivityAddCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        binding.iconsList.setLayoutManager(gridLayoutManager);
        binding.iconsList.setAdapter(new IconsAdapter(icons, this));

        binding.switcher.setOnClickListener(view -> {
            binding.switcher.setText(!binding.switcher.isChecked() ? "Доход" : "Трата");
        });

        binding.addButton.setOnClickListener(view -> {
            if (!binding.name.getText().toString().isEmpty()) {
                String name = binding.name.getText().toString();
                int iconID = icons[((IconsAdapter)binding.iconsList.getAdapter()).choosenID];


                Category category = new Category(name, iconID, !binding.switcher.isChecked());

                Intent intent = new Intent();
                intent.putExtra("isIncome", !binding.switcher.isChecked());
                intent.putExtra("category", category);
                setResult(RESULT_OK, intent);


                finish();
            } else {
                Toast.makeText(this, "Необходимо ввести название", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

