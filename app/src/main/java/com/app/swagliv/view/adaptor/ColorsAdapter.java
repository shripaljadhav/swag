package com.app.swagliv.view.adaptor;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.swagliv.R;

import java.util.ArrayList;

public class ColorsAdapter extends RecyclerView.Adapter<ColorsAdapter.ColorsViewHolder> {

    private final ArrayList<String> colors;

    public ColorsAdapter() {
        colors = new ArrayList<String>();
        colors.add("#ff0000");
        colors.add("#000000");
        colors.add("#964B00");
    }

    @NonNull
    @Override
    public ColorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ColorsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_colors,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ColorsViewHolder holder, int position) {
        LinearLayout textViewColor = (LinearLayout) holder.itemView;
        GradientDrawable drawable = (GradientDrawable) textViewColor.getBackground();
        drawable.setColor(Color.parseColor(colors.get(position)));
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

    static final class ColorsViewHolder extends RecyclerView.ViewHolder{

        public ColorsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
