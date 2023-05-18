package com.example.financecontroller.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.financecontroller.DataClasses.Category;
import com.example.financecontroller.DataClasses.Transaction;
import com.example.financecontroller.R;
import com.example.financecontroller.Adapters.TransactionAdapter;
import com.example.financecontroller.databinding.FragmentTransactionsBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class TransactionsFragment extends Fragment {

    FragmentTransactionsBinding binding;

    List<Transaction> incomeList;
    List<Transaction> spendList;
    List<Transaction> list = new ArrayList<>();
    List<Category> categoryList;


    public TransactionsFragment(List<Transaction> incomeList, List<Transaction> spendList, List<Category> categoryList) {
        this.incomeList = incomeList;
        this.spendList = spendList;
        this.categoryList = categoryList;
    }

    public TransactionsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentTransactionsBinding.inflate(getLayoutInflater());

        binding.transactions.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));


        binding.transactions.setAdapter(new TransactionAdapter(list, categoryList));


        binding.tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                list.clear();
                list.addAll(tab.getPosition() == 0 ? spendList : incomeList);
                binding.transactions.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if(Objects.requireNonNull(binding.transactions.getAdapter()).getItemCount() > 0) {
                    binding.transactions.smoothScrollToPosition(0);
                    getActivity().findViewById(R.id.bottomAppBar).animate().translationY(0).setDuration(200);
                }
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();

        list.clear();

        list.addAll(binding.tabs.getSelectedTabPosition() == 1 ? incomeList : spendList);

        binding.transactions.getAdapter().notifyDataSetChanged();

        //binding.sum.setText(MainActivity.db.wallet.getSum() + "" + MainActivity.db.account.getCurrency().getSymbol());
    }
}