package com.example.financecontroller.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financecontroller.DataClasses.Category;
import com.example.financecontroller.DataClasses.Transaction;
import com.example.financecontroller.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> {

    private final List<Transaction> list;
    private final List<Category> categoryList;

    public TransactionAdapter(List<Transaction> list, List<Category> categoryList) {
        this.list = list;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Transaction transaction = list.get(list.size()-position-1);
        final Category category = findCategory(transaction.categoryID);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(transaction.date);

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy hh:mm");

        holder.date.setText(formatter.format(calendar.getTime()));
        holder.value.setText(String.valueOf(transaction.value));
        holder.categoryName.setText(category.name);
        holder.icon.setImageResource(category.iconID);
        holder.currency.setText(transaction.currency);
        int incomeColor = -2818048;
        int spendColor = -10167017;
        holder.value.setTextColor(category.isIncome ? spendColor : incomeColor);
        holder.currency.setTextColor(category.isIncome ? spendColor : incomeColor);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private Category findCategory(int id) {
        for (Category category : categoryList) {
            if (id == category.id) return category;
        }
        throw new RuntimeException("Didn`t found Category from id");
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView date;
        private final TextView value;
        private final TextView categoryName;
        private final ImageView icon;
        private final TextView currency;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            value = itemView.findViewById(R.id.value);
            currency = itemView.findViewById(R.id.currency);
            categoryName = itemView.findViewById(R.id.categoryName);
            icon = itemView.findViewById(R.id.transaction_icon);

        }

    }

}
