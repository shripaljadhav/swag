package com.app.swagliv.view.adaptor;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.app.swagliv.R;

public class ProgressIndicatorAdapter extends RecyclerView.Adapter<ProgressIndicatorAdapter.ProgressIndicatorViewHolder> {

    private final int size;
    private int selectedPosition=0;

    public ProgressIndicatorAdapter(int size) {
        this.size = size;
    }

    @NonNull
    @Override
    public ProgressIndicatorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProgressIndicatorViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_progress,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProgressIndicatorViewHolder holder, int position) {
        if(position==selectedPosition){
            holder.itemView.setBackgroundColor(Color.BLACK);
        }else {
            holder.itemView.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return size;
    }

    public void setCurrentPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        notifyDataSetChanged();
    }

    static final class ProgressIndicatorViewHolder extends RecyclerView.ViewHolder{

        public ProgressIndicatorViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
