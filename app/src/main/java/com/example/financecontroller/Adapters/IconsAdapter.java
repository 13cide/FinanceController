package com.example.financecontroller.Adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financecontroller.R;

public class IconsAdapter extends RecyclerView.Adapter<IconsAdapter.MyViewHolder> {
    public int choosenID = 0;
    private int m = 4;

    private final int[] list;

    private Context context;

    public IconsAdapter(int[] list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_item, parent, false);
        return new IconsAdapter.MyViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.icon.setImageResource(list[position]);

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
        return list.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView icon;
        private final IconsAdapter adapter;
        private final CardView foreground;

        public MyViewHolder(@NonNull View itemView, IconsAdapter adapter) {
            super(itemView);
            itemView.setOnClickListener(this);
            icon = itemView.findViewById(R.id.icon);
            foreground = itemView.findViewById(R.id.cardd);
            this.adapter = adapter;
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != adapter.choosenID) {

                ViewGroup.MarginLayoutParams marginParams = new ViewGroup.MarginLayoutParams(foreground.getLayoutParams());
                int m = 4;
                marginParams.setMargins(m, m, m, m);
                CardView.LayoutParams layoutParams = new CardView.LayoutParams(marginParams);
                foreground.setLayoutParams(layoutParams);
                adapter.notifyItemChanged(adapter.choosenID);
                adapter.choosenID = position;
            }
        }
    }
}
