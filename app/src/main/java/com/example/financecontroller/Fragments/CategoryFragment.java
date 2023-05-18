package com.example.financecontroller.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.financecontroller.Adapters.CategoryAdapter;
import com.example.financecontroller.DataClasses.Category;
import com.example.financecontroller.R;
import com.example.financecontroller.databinding.FragmentCategoryBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CategoryFragment extends Fragment {

    FragmentCategoryBinding binding;

    List<Category> incomeList;
    List<Category> spendList;
    List<Category> list = new ArrayList<>();

    public CategoryFragment(List<Category> incomeList, List<Category> spendList) {
        this.incomeList = incomeList;
        this.spendList = spendList;
    }

    public CategoryFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCategoryBinding.inflate(getLayoutInflater());

        binding.categories.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        list.addAll(spendList);
        binding.categories.setAdapter(new CategoryAdapter(list));

        binding.tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                list.clear();
                list.addAll(tab.getPosition() == 0 ? spendList : incomeList);
                binding.categories.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if(Objects.requireNonNull(binding.categories.getAdapter()).getItemCount() > 0) {
                    binding.categories.smoothScrollToPosition(0);
                    getActivity().findViewById(R.id.bottomAppBar).animate().translationY(0).setDuration(200);
                }
            }
        });

        return binding.getRoot();
    }


}