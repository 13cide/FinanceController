package com.example.financecontroller.Adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financecontroller.DataClasses.Category;
import com.example.financecontroller.R;

import java.util.List;

public class AddTransactionCategoryAdapter extends RecyclerView.Adapter<AddTransactionCategoryAdapter.MyViewHolder> {

    private final List<Category> list;
    private final Context context;
    public int choosenID = 0;
    private final int m = 6;

    public AddTransactionCategoryAdapter(List<Category> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public AddTransactionCategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.small_category_item, parent, false);
        return new AddTransactionCategoryAdapter.MyViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull AddTransactionCategoryAdapter.MyViewHolder holder, int position) {
        final Category category = list.get(position);

        holder.name.setText(category.name);
        holder.icon.setImageResource(category.iconID);
        ViewGroup.MarginLayoutParams marginParams = new ViewGroup.MarginLayoutParams(holder.foreground.getLayoutParams());
        if (position == choosenID)
            marginParams.setMargins(m, m, m, m);
        else
            marginParams.setMargins(0,0, 0, 0);
        CardView.LayoutParams layoutParams = new CardView.LayoutParams(marginParams);
        holder.foreground.setLayoutParams(layoutParams);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView name;
        private final ImageView icon;
        private final CardView foreground;

        private AddTransactionCategoryAdapter adapter;

        public MyViewHolder(@NonNull View itemView, AddTransactionCategoryAdapter adapter) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.category_name);
            icon = itemView.findViewById(R.id.category_icon);
            foreground = itemView.findViewById(R.id.foreground);
            this.adapter = adapter;
        }

        @Override
        public void onClick(View v)
        {
            int position = getAdapterPosition();

            if (position != adapter.choosenID) {
                ViewGroup.MarginLayoutParams marginParams = new ViewGroup.MarginLayoutParams(foreground.getLayoutParams());
                int m = 6;
                marginParams.setMargins(m, m, m, m);
                CardView.LayoutParams layoutParams = new CardView.LayoutParams(marginParams);
                foreground.setLayoutParams(layoutParams);
                adapter.notifyItemChanged(adapter.choosenID);
                adapter.choosenID = position;
            }

        }
    }
}
