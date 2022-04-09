package com.app.swagliv.view.adaptor;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.swagliv.R;
import com.app.swagliv.databinding.ItemProductListingBinding;
import com.app.swagliv.model.store.OwnProduct;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;

public class ProductListingAdapter extends RecyclerView.Adapter<ProductListingAdapter.ProductListingViewHolder> {

    private final ArrayList<OwnProduct> ownProducts;

    public ProductListingAdapter(ArrayList<OwnProduct> ownProducts) {
        this.ownProducts = ownProducts;
    }

    @NonNull
    @Override
    public ProductListingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductListingBinding itemProductListingBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_product_listing, parent, false);
        return new ProductListingViewHolder(itemProductListingBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListingViewHolder holder, int position) {
        OwnProduct ownProduct = ownProducts.get(position);
        Glide.with(holder.itemView.getContext())
                .load(ownProduct.getProductImages().get(0))
                .transform(new CenterCrop(),new RoundedCorners(holder.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.dp4)))
                .into(holder.itemProductListingBinding.image);
        holder.itemProductListingBinding.textviewProductValue.setText(ownProduct.getProductName());
        holder.itemProductListingBinding.textviewRateValue.setText(String.valueOf(ownProduct.getCoins()));
    }

    @Override
    public int getItemCount() {
        return ownProducts.size();
    }

    static final class ProductListingViewHolder extends RecyclerView.ViewHolder{
        private final ItemProductListingBinding itemProductListingBinding;
        public ProductListingViewHolder(@NonNull ItemProductListingBinding itemProductListingBinding) {
            super(itemProductListingBinding.getRoot());
            this.itemProductListingBinding = itemProductListingBinding;
        }
    }

}


