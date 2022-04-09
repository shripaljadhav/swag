package com.app.swagliv.view.activities;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.common.utils.Utility;
import com.app.progressbar.LoadingProgressBarDialog;
import com.app.swagliv.R;
import com.app.swagliv.databinding.ActivityProductListingBinding;
import com.app.swagliv.model.store.OwnProduct;
import com.app.swagliv.view.adaptor.ProductListingAdapter;
import com.app.swagliv.model.Error;
import com.app.swagliv.model.Loading;
import com.app.swagliv.model.Result;
import com.app.swagliv.viewmodel.store.StoreViewModel;
import com.app.swagliv.model.Success;

import java.util.ArrayList;

public class ProductListingActivity extends AppCompatActivity implements View.OnClickListener {

    private AlertDialog mProgressbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityProductListingBinding activityProductListingBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_product_listing);
        activityProductListingBinding.EditHeader.headerTitle.setText(getResources().getString(R.string.title_product_listing));
        activityProductListingBinding.EditHeader.backBtn.setOnClickListener(this);
        final StoreViewModel storeViewModel = StoreViewModel.getInstance(getApplication());
        storeViewModel.getProductListing().observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result result) {
                if (result instanceof Loading) {
                    mProgressbar = new LoadingProgressBarDialog.Builder()
                            .setContext(ProductListingActivity.this)
                            .setMessage(getString(R.string.please_wait))
                            .build();
                    mProgressbar.show();
                } else if (result instanceof Success) {
                    Success<ArrayList<OwnProduct>> ownProducts = (Success<ArrayList<OwnProduct>>) result;
                    activityProductListingBinding
                            .recyclerview
                            .setAdapter(new ProductListingAdapter(ownProducts.getData()));
                    activityProductListingBinding
                            .recyclerview
                            .setLayoutManager(new LinearLayoutManager(ProductListingActivity.this));
                    activityProductListingBinding
                            .recyclerview
                            .addItemDecoration(new RecyclerView.ItemDecoration() {
                                @Override
                                public void getItemOffsets(@NonNull Rect outRect, int itemPosition, @NonNull RecyclerView parent) {
                                    outRect.top = getResources().getDimensionPixelSize(R.dimen.dp24);
                                    outRect.left = getResources().getDimensionPixelSize(R.dimen.dp16);
                                    outRect.right = getResources().getDimensionPixelSize(R.dimen.dp16);
                                    if ((parent.getAdapter().getItemCount() - 1) == itemPosition) {
                                        outRect.bottom = getResources().getDimensionPixelSize(R.dimen.dp24);
                                    }
                                }
                            });
                    mProgressbar.dismiss();
                } else if (result instanceof Error) {
                    mProgressbar.dismiss();
                    Error error = (Error) result;
                    Utility.showToast(getApplicationContext(),error.getException().getMessage());
                }
            }
        });
        activityProductListingBinding.fabAddProduct.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_add_product:
                startActivity(new Intent(this, AddProductActivity.class));
                break;
            case R.id.back_btn:
                finish();
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }
}
