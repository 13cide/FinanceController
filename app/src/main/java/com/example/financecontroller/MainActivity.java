package com.example.financecontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.financecontroller.DataClasses.Localdb;
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
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        swapFragment(new TransactionsFragment());

        binding.transactions.setOnClickListener(view -> {
            if (chosenFragment != 1) {
                binding.transactions.setImageResource(R.drawable.transactions_open);
                binding.statistic.setImageResource(R.drawable.statistic_close);
                swapFragment(new TransactionsFragment());
                chosenFragment = 1;
            }
        });

        binding.statistic.setOnClickListener(view -> {
            if (chosenFragment != 2) {
                binding.transactions.setImageResource(R.drawable.transactions_close);
                binding.statistic.setImageResource(R.drawable.statistic_open);
                swapFragment(new StatisticFragment());
                chosenFragment = 2;
            }
        });
    }

    private void swapFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_content, fragment);
        transaction.commit();
    }

}