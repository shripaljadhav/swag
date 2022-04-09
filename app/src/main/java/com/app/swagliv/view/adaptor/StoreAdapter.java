package com.app.swagliv.view.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.swagliv.R;
import com.app.swagliv.databinding.ItemStoreBinding;
import com.app.swagliv.model.store.OwnProduct;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder>{

    private final ArrayList<OwnProduct> products;
    private final ArrayList<OwnProduct> displayableProducts;
    private final View.OnClickListener onClickListener;

    public StoreAdapter(ArrayList<OwnProduct> products, View.OnClickListener onClickListener) {
        this.products = products;
        this.displayableProducts = new ArrayList<>(products);
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStoreBinding itemStoreBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_store, parent, false);
        return new StoreViewHolder(itemStoreBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder holder, int position) {
        OwnProduct ownProduct = displayableProducts.get(position);
        Glide.with(holder.itemView.getContext())
                .load(ownProduct.getProductImages().get(0))
                .transform(new CenterCrop(),new RoundedCorners(holder.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.dp8)))
                .into(holder.itemStoreBinding.image);
        holder.itemStoreBinding.textviewProductName.setText(ownProduct.getProductName());
        holder.itemStoreBinding.textviewCoins.setText(String.valueOf((int) ownProduct.getCoins()).concat(" "+holder.itemView.getContext().getResources().getString(R.string.coins)));
        holder.itemStoreBinding.getRoot().setOnClickListener(onClickListener);
        holder.itemStoreBinding.getRoot().setTag(R.string.tag_product,ownProduct);
    }

    @Override
    public int getItemCount() {
        return displayableProducts.size();
    }

    public ArrayList<OwnProduct> getProducts() {
        return products;
    }

    public void notifyDataSetChanged(ArrayList<OwnProduct> data) {
        displayableProducts.clear();
        displayableProducts.addAll(data);
        notifyDataSetChanged();
    }

    public void reset() {
        displayableProducts.clear();
        displayableProducts.addAll(products);
        notifyDataSetChanged();
    }

    static final class StoreViewHolder extends RecyclerView.ViewHolder{

        private final ItemStoreBinding itemStoreBinding;

        public StoreViewHolder(@NonNull ItemStoreBinding itemStoreBinding) {
            super(itemStoreBinding.getRoot());
            this.itemStoreBinding = itemStoreBinding;
        }
    }
}
