package com.example.financecontroller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financecontroller.DataClasses.Transaction;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> {

    private final List<Transaction> list;

    public TransactionAdapter(List<Transaction> list) {
        this.list = list;
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


        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(transaction.date);

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy hh:mm");

        holder.date.setText(formatter.format(calendar.getTime()));
        holder.value.setText(String.valueOf(transaction.value));
        holder.categoryName.setText(transaction.category.name);
        holder.icon.setImageResource(transaction.category.iconID);
        //holder.icon.setBackgroundResource(transaction.getCategory().getColorID());
        holder.currency.setText(transaction.currency_symbol);
        int incomeColor = -2818048;
        int spendColor = -10167017;
        holder.value.setTextColor(transaction.category.isIncome ? spendColor : incomeColor);
        holder.currency.setTextColor(transaction.category.isIncome ? spendColor : incomeColor);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
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
