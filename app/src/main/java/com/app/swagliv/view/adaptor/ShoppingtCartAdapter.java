package com.app.swagliv.view.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.app.swagliv.R;
import com.app.swagliv.databinding.ItemShoppingCartBinding;
import com.app.swagliv.model.store.CartProduct;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;

public class ShoppingtCartAdapter extends ListAdapter<CartProduct,ShoppingtCartAdapter.ShoppingtCartViewHolder> {

    private final View.OnClickListener onClickListener;

    public ShoppingtCartAdapter(View.OnClickListener onClickListener) {
        super(new ShoppingItemDiffUtilCallBack());
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ShoppingtCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemShoppingCartBinding itemShoppingCartBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_shopping_cart, parent, false);
        return new ShoppingtCartViewHolder(itemShoppingCartBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingtCartViewHolder holder, int position) {
        final CartProduct cartProduct = getItem(position);
        holder.itemShoppingCartBinding.textviewProductValue.setText(cartProduct.getProductName());
        holder.itemShoppingCartBinding.textviewRateValue.setText(String.valueOf((int)cartProduct.getCoins()));
        Glide.with(holder.itemView.getContext())
                .load(cartProduct.getProductImages().get(0))
                .transform(new CenterCrop(),new RoundedCorners(holder.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.dp4)))
                .into(holder.itemShoppingCartBinding.image);
        holder.itemShoppingCartBinding.imageviewDelete.setTag(R.string.tag_my_cart_product,cartProduct);
        holder.itemShoppingCartBinding.imageviewDelete.setOnClickListener(onClickListener);
    }

    public ArrayList<CartProduct> getItems() {
        return new ArrayList<CartProduct>(getCurrentList());
    }

    static final class ShoppingtCartViewHolder extends RecyclerView.ViewHolder{

        final ItemShoppingCartBinding itemShoppingCartBinding;

        public ShoppingtCartViewHolder(@NonNull ItemShoppingCartBinding itemShoppingCartBinding) {
            super(itemShoppingCartBinding.getRoot());
            this.itemShoppingCartBinding = itemShoppingCartBinding;
        }
    }

    static final class ShoppingItemDiffUtilCallBack extends DiffUtil.ItemCallback<CartProduct>{
        @Override
        public boolean areItemsTheSame(@NonNull CartProduct oldItem, @NonNull CartProduct newItem) {
            return oldItem.get_id() == oldItem.get_id();
        }

        @Override
        public boolean areContentsTheSame(@NonNull CartProduct oldItem, @NonNull CartProduct newItem) {
            return oldItem.equals(newItem);
        }
    }
}
