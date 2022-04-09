package com.app.swagliv.view.activities;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.common.utils.Utility;
import com.app.progressbar.LoadingProgressBarDialog;
import com.app.swagliv.R;
import com.app.swagliv.databinding.ActivityStoreBinding;
import com.app.swagliv.model.store.OwnProduct;
import com.app.swagliv.view.FilterListener;
import com.app.swagliv.view.adaptor.StoreAdapter;
import com.app.swagliv.view.fragment.FilterBottomSheetFragment;
import com.app.swagliv.model.Error;
import com.app.swagliv.model.Loading;
import com.app.swagliv.model.Result;
import com.app.swagliv.viewmodel.store.StoreViewModel;
import com.app.swagliv.model.Success;

import java.util.ArrayList;

public class StoreActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener, FilterListener {

    ActivityStoreBinding activityStoreBinding;
    StoreViewModel storeViewModel;
    private AlertDialog mProgressbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityStoreBinding = DataBindingUtil.setContentView(this, R.layout.activity_store);
        activityStoreBinding.EditHeader.headerTitle.setText(getResources().getString(R.string.title_store));
        storeViewModel = StoreViewModel.getInstance(getApplication());
        storeViewModel.getAllProducts().observe(this, result -> {
            if (result instanceof Loading) {
                mProgressbar = new LoadingProgressBarDialog.Builder()
                        .setContext(StoreActivity.this)
                        .setMessage(getString(R.string.please_wait))
                        .build();
                mProgressbar.show();
            } else if (result instanceof Success) {
                Success<ArrayList<OwnProduct>> ownProducts = (Success<ArrayList<OwnProduct>>) result;
                activityStoreBinding.recyclerview.setAdapter(new StoreAdapter(ownProducts.getData(), StoreActivity.this));
                activityStoreBinding.recyclerview.setLayoutManager(new GridLayoutManager(StoreActivity.this, 3));
                activityStoreBinding
                        .recyclerview
                        .addItemDecoration(new RecyclerView.ItemDecoration() {
                            @Override
                            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                                outRect.top = getResources().getDimensionPixelSize(R.dimen.dp16);
                                outRect.left = getResources().getDimensionPixelSize(R.dimen.dp16);
                                outRect.right = getResources().getDimensionPixelSize(R.dimen.dp16);
                            }
                        });
                mProgressbar.dismiss();
            } else if (result instanceof Error) {
                mProgressbar.dismiss();
                Error error = (Error) result;
                Utility.showToast(getApplicationContext(), error.getException().getMessage());
            }
        });
        activityStoreBinding.edittextSearch.addTextChangedListener(this);
        activityStoreBinding.EditHeader.btnFilter.setOnClickListener(this);
        activityStoreBinding.EditHeader.backBtn.setOnClickListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        final StoreAdapter storeAdapter = (StoreAdapter) activityStoreBinding
                .recyclerview
                .getAdapter();
        if (storeAdapter != null) {
            storeViewModel.searchProducts(s.toString().trim(), storeAdapter.getProducts())
                    .observe(this, result -> {
                        if (result instanceof Success) {
                            Success<ArrayList<OwnProduct>> success = (Success<ArrayList<OwnProduct>>) result;
                            storeAdapter.notifyDataSetChanged(success.getData());
                        } else if (result instanceof Error) {
                            storeAdapter.reset();
                        }
                    });
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_filter:
                FilterBottomSheetFragment filterBottomSheetFragment = new FilterBottomSheetFragment();
                final Bundle bundle = new Bundle();
                final StoreAdapter storeAdapter = (StoreAdapter) activityStoreBinding.recyclerview.getAdapter();
                bundle.putSerializable("products", storeAdapter.getProducts());
                filterBottomSheetFragment.setArguments(bundle);
                filterBottomSheetFragment.show(getSupportFragmentManager(), null);
                break;
            case R.id.item:
                Intent intent = new Intent(this, StoreProductDetailActivity.class);
                OwnProduct ownProduct = (OwnProduct) v.getTag(R.string.tag_product);
                intent.putExtra("product_detail", ownProduct);
                startActivity(intent);
                break;
            case R.id.back_btn:
                finish();
                break;

        }
    }

    @Override
    public void filteredResult(ArrayList<OwnProduct> data) {
        final StoreAdapter storeAdapter = (StoreAdapter) activityStoreBinding
                .recyclerview
                .getAdapter();
        storeAdapter.notifyDataSetChanged(data);
    }
}
