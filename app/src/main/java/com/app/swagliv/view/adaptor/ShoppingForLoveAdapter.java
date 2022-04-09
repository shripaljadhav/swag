package com.app.swagliv.view.adaptor;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ShoppingForLoveAdapter extends RecyclerView.Adapter<ShoppingForLoveAdapter.ShoppingForLoveViewHolder> {

    @NonNull
    @Override
    public ShoppingForLoveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingForLoveViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static final class ShoppingForLoveViewHolder extends RecyclerView.ViewHolder{

        public ShoppingForLoveViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
