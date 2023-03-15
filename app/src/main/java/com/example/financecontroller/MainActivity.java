package com.example.financecontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

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

        swapFragment(new TransactionsFragment());

        binding.historyLayout.setOnClickListener(view -> {
            if (chosenFragment != 1) {

                binding.historyLayout.setBackgroundResource(R.drawable.round_back_history);
                binding.historyIcon.setImageResource(R.drawable.history_selected_icon);
                binding.historyText.setVisibility(View.VISIBLE);

                binding.categoryLayout.setBackgroundResource(R.drawable.transparent_background);
                binding.categoryIcon.setImageResource(R.drawable.categories_icon);
                binding.categoryText.setVisibility(View.GONE);

                binding.statisticLayout.setBackgroundResource(R.drawable.transparent_background);
                binding.statisticIcon.setImageResource(R.drawable.statistic_icon);
                binding.statisticText.setVisibility(View.GONE);

                swapFragment(new TransactionsFragment());
                chosenFragment = 1;
            }
        });

        binding.categoryLayout.setOnClickListener(view -> {
            if (chosenFragment != 2) {

                binding.historyLayout.setBackgroundResource(R.drawable.transparent_background);
                binding.historyIcon.setImageResource(R.drawable.history_icon);
                binding.historyText.setVisibility(View.GONE);

                binding.categoryLayout.setBackgroundResource(R.drawable.round_back_category);
                binding.categoryIcon.setImageResource(R.drawable.categories_selected_icon);
                binding.categoryText.setVisibility(View.VISIBLE);

                binding.statisticLayout.setBackgroundResource(R.drawable.transparent_background);
                binding.statisticIcon.setImageResource(R.drawable.statistic_icon);
                binding.statisticText.setVisibility(View.GONE);


                swapFragment(new CategoryFragment());
                chosenFragment = 2;
            }
        });

        binding.statisticLayout.setOnClickListener(view -> {
            if (chosenFragment != 3) {

                binding.historyLayout.setBackgroundResource(R.drawable.transparent_background);
                binding.historyIcon.setImageResource(R.drawable.history_icon);
                binding.historyText.setVisibility(View.GONE);

                binding.categoryLayout.setBackgroundResource(R.drawable.transparent_background);
                binding.categoryIcon.setImageResource(R.drawable.categories_icon);
                binding.categoryText.setVisibility(View.GONE);

                binding.statisticLayout.setBackgroundResource(R.drawable.round_back_statistic);
                binding.statisticIcon.setImageResource(R.drawable.statistic_selected_icon);
                binding.statisticText.setVisibility(View.VISIBLE);


                swapFragment(new StatisticFragment());
                chosenFragment = 3;
            }
        });


    }



    private void swapFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_content, fragment);
        transaction.commit();
    }


}