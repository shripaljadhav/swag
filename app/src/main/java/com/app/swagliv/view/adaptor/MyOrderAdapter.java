package com.app.swagliv.view.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.swagliv.R;
import com.app.swagliv.databinding.ItemMyOrderBinding;
import com.app.swagliv.model.store.Order;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyOrderViewHolder> {

    private final ArrayList<Order> orders;
    private final View.OnClickListener onClickListener;

    public MyOrderAdapter(ArrayList<Order> orders, View.OnClickListener onClickListener) {
        this.orders = orders;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public MyOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMyOrderBinding itemMyOrderBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_my_order, parent, false);
        return new MyOrderViewHolder(itemMyOrderBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderViewHolder holder, int position) {
        final Order order = orders.get(position);
        Glide.with(holder.itemView.getContext())
                .load(order.getProductImages().get(0))
                .transform(new CenterCrop(),new RoundedCorners(holder.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.dp4)))
                .into(holder.itemMyOrderBinding.image);
        holder.itemMyOrderBinding.textviewProductValue.setText(order.getProductName());
        holder.itemMyOrderBinding.textviewRateValue.setText(String.valueOf(order.getCoins()));
        holder.itemMyOrderBinding.textviewStatusValue.setText(order.getOrderStatus().toUpperCase());
        holder.itemView.setTag(R.string.tag_selected_order,order);
        holder.itemView.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    static final class MyOrderViewHolder extends RecyclerView.ViewHolder{

        final ItemMyOrderBinding itemMyOrderBinding;

        public MyOrderViewHolder(@NonNull ItemMyOrderBinding itemMyOrderBinding) {
            super(itemMyOrderBinding.getRoot());
            this.itemMyOrderBinding = itemMyOrderBinding;
        }
    }
}
