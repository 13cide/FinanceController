package com.example.financecontroller;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.financecontroller.DataClasses.Category;
import com.example.financecontroller.DataClasses.Currency;
import com.example.financecontroller.DataClasses.Transaction;
import com.example.financecontroller.Fragments.CategoryFragment;
import com.example.financecontroller.Fragments.StatisticFragment;
import com.example.financecontroller.Fragments.TransactionsFragment;
import com.example.financecontroller.Room.DatabaseDAO;
import com.example.financecontroller.databinding.ActivityMainBinding;
import com.google.android.material.color.DynamicColors;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    final private FragmentManager fragmentManager = getSupportFragmentManager();

    private int chosenFragment = 1;

    DatabaseDAO dao;

    List<Transaction> incomeList = new ArrayList<>();
    List<Transaction> spendList = new ArrayList<>();

    List<Category> categoryIncome = new ArrayList<>();
    List<Category> categorySpend = new ArrayList<>();
    List<Category> categoryList = new ArrayList<>();
    List<Currency> currencyList = new ArrayList<>();

    ActivityResultLauncher<Intent> activityResultLauncher =
            registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent data = result.getData();
                        if (result.getResultCode() == RESULT_OK) {
                            if (chosenFragment == 1) {
                                Transaction transaction = (Transaction) data.getSerializableExtra("transaction");
                                (data.getBooleanExtra("isIncome", true) ? incomeList : spendList).add(transaction);
                                new Thread(() -> {
                                    dao.save(transaction);
                                }).start();
                            }
                            else {
                                Category category = (Category) data.getSerializableExtra("category");
                                (data.getBooleanExtra("isIncome", true) ? categoryIncome : categorySpend).add(category);
                                categoryList.add(category);
                                new Thread(() -> {
                                    dao.save(category);
                                }).start();
                            }
                        }
                    }
                }
            );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DynamicColors.applyToActivityIfAvailable(this);

        dao = App.getDatabase().DAO();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, chosenFragment == 1 ? AddTransactionActivity.class : AddCategoryActivity.class);
            activityResultLauncher.launch(intent);
        });

        new Thread(() -> {
            if (dao.getIncomeCategories().isEmpty()) {
                dao.save(new Category("зарплата", R.drawable.icon_salary, true));
                dao.save(new Category("проценты", R.drawable.icon_percents, true));
                dao.save(new Category("подарки", R.drawable.icon_gift, true));
                dao.save(new Category("другое", R.drawable.icon_else, true));
                dao.save(new Category("досуг", R.drawable.icon_chilling, false));
                dao.save(new Category("продукты", R.drawable.icon_else, false));
                dao.save(new Category("семья", R.drawable.icon_family, false));
                dao.save(new Category("учёба", R.drawable.icon_education, false));
                dao.save(new Category("подарки", R.drawable.icon_gift, false));
                dao.save(new Category("дом", R.drawable.icon_home, false));
                dao.save(new Category("перелёты", R.drawable.icon_6, false));
                dao.save(new Category("техниа", R.drawable.icon_9, false));
                dao.save(new Category("другое", R.drawable.icon_else, false));
            }
            incomeList.addAll(dao.getIncomes());
            spendList.addAll(dao.getSpends());
            categoryIncome.addAll(dao.getIncomeCategories());
            categorySpend.addAll(dao.getSpendCategories());
            categoryList.addAll(categoryIncome);
            categoryList.addAll(categorySpend);
            currencyList.addAll(dao.getCurrencies());
        }).start();




        swapFragment(new TransactionsFragment(incomeList, spendList, categoryList));



        binding.bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.history:
                        if (chosenFragment != 1) {
                            swapFragment(new TransactionsFragment(incomeList, spendList, categoryList));
                            chosenFragment = 1;
                            item.setIcon(R.drawable.history_icon_selected);
                            binding.bottomAppBar.getMenu().getItem(1).setIcon(R.drawable.categories_icon);
                            binding.addButton.setImageResource(R.drawable.history_icon);
                        }
                        return true;

                    case R.id.category:
                        if (chosenFragment != 3) {
                            swapFragment(new CategoryFragment(categoryIncome, categorySpend));
                            chosenFragment = 3;
                            binding.bottomAppBar.getMenu().getItem(0).setIcon(R.drawable.history_icon);
                            item.setIcon(R.drawable.categories_icon_selected);
                            binding.addButton.setImageResource(R.drawable.categories_icon);

                        }
                        return true;
                }
                return false;
            }
        });

    }



    private void swapFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_content, fragment);
        transaction.commit();
    }

}