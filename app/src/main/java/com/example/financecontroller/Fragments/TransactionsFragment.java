package com.example.financecontroller.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.financecontroller.AddTransactionActivity;
import com.example.financecontroller.DataClasses.Localdb;
import com.example.financecontroller.DataClasses.Transaction;
import com.example.financecontroller.MainActivity;
import com.example.financecontroller.R;
import com.example.financecontroller.TransactionAdapter;
import com.example.financecontroller.databinding.ActivityMainBinding;
import com.example.financecontroller.databinding.FragmentTransactionsBinding;

import java.util.ArrayList;
import java.util.List;


public class TransactionsFragment extends Fragment {

    FragmentTransactionsBinding binding;

    List<Transaction> incomeList = new ArrayList<>();
    List<Transaction> spendList = new ArrayList<>();
    List<Transaction> list = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentTransactionsBinding.inflate(getLayoutInflater());

        binding.transactions.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));


        spendList = MainActivity.db.wallet.getAccounts()[0].getSpends();
        incomeList= MainActivity.db.wallet.getAccounts()[0].getIncomes();

        binding.transactions.setAdapter(new TransactionAdapter(list));
        binding.spendButton.setOnClickListener(view -> {
            list.clear();
            list.addAll(spendList);
            binding.transactions.getAdapter().notifyDataSetChanged();
        });

        binding.incomeButton.setOnClickListener(view -> {
            list.clear();
            list.addAll(incomeList);
            binding.transactions.getAdapter().notifyDataSetChanged();
        });

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        spendList = MainActivity.db.wallet.getAccounts()[0].getSpends();
        incomeList = MainActivity.db.wallet.getAccounts()[0].getIncomes();

        list.clear();
        list.addAll(spendList);
        binding.transactions.getAdapter().notifyDataSetChanged();

        binding.sum.setText(MainActivity.db.wallet.getSum() + "" + MainActivity.db.account.getCurrency().getSymbol());
    }
}