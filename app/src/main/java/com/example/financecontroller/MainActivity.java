package com.example.financecontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.financecontroller.DataClasses.Localdb;
import com.example.financecontroller.Fragments.CategoryFragment;
import com.example.financecontroller.Fragments.StatisticFragment;
import com.example.financecontroller.Fragments.TransactionsFragment;
import com.example.financecontroller.databinding.ActivityMainBinding;
import com.google.android.material.color.DynamicColors;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    final private FragmentManager fragmentManager = getSupportFragmentManager();

    public static Localdb db = new Localdb();
    private int chosenFragment = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DynamicColors.applyToActivityIfAvailable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddTransactionActivity.class);
            startActivity(intent);
        });

        swapFragment(new TransactionsFragment());

        binding.bottomAppBar.setNavigationOnClickListener(view -> {

        });

        binding.bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.history:
                        if (chosenFragment != 1) {
                            swapFragment(new TransactionsFragment());
                            chosenFragment = 1;
                            item.setIcon(R.drawable.history_icon_selected);
                            binding.bottomAppBar.getMenu().getItem(1).setIcon(R.drawable.statistic_icon);
                            binding.bottomAppBar.getMenu().getItem(2).setIcon(R.drawable.categories_icon);
                        }
                        return true;

                    case R.id.statistic:
                        if (chosenFragment != 2) {
                            swapFragment(new StatisticFragment());
                            chosenFragment = 2;
                            binding.bottomAppBar.getMenu().getItem(0).setIcon(R.drawable.history_icon);
                            item.setIcon(R.drawable.statistic_icon_selected);
                            binding.bottomAppBar.getMenu().getItem(2).setIcon(R.drawable.categories_icon);
                        }
                        return true;

                    case R.id.category:
                        if (chosenFragment != 3) {
                            swapFragment(new CategoryFragment());
                            chosenFragment = 3;
                            binding.bottomAppBar.getMenu().getItem(0).setIcon(R.drawable.history_icon);
                            binding.bottomAppBar.getMenu().getItem(1).setIcon(R.drawable.statistic_icon);
                            item.setIcon(R.drawable.categories_icon_selected);
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