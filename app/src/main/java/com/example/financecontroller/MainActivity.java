package com.example.financecontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.financecontroller.DataClasses.Localdb;
import com.example.financecontroller.Fragments.CategoryFragment;
import com.example.financecontroller.Fragments.StatisticFragment;
import com.example.financecontroller.Fragments.TransactionsFragment;
import com.example.financecontroller.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    final private FragmentManager fragmentManager = getSupportFragmentManager();

    public static Localdb db = new Localdb();
    private int chosenFragment = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int s = getResources().getColor(R.color.spend, null);
        super.onCreate(savedInstanceState);
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
                        }
                        return true;

                    case R.id.statistic:
                        if (chosenFragment != 2) {
                            swapFragment(new StatisticFragment());
                            chosenFragment = 2;
                        }
                        return true;

                    case R.id.category:
                        if (chosenFragment != 3) {
                            swapFragment(new CategoryFragment());
                            chosenFragment = 3;
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