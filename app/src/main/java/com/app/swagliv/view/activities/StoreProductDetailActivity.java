package com.app.swagliv.view.activities;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.app.common.utils.Utility;
import com.app.progressbar.LoadingProgressBarDialog;
import com.app.swagliv.R;
import com.app.swagliv.databinding.ActivityStoreProductDetailBinding;
import com.app.swagliv.model.Error;
import com.app.swagliv.model.Loading;
import com.app.swagliv.model.store.OwnProduct;
import com.app.swagliv.view.adaptor.ColorsAdapter;
import com.app.swagliv.view.adaptor.ImagesAdapter;
import com.app.swagliv.view.adaptor.ProgressIndicatorAdapter;
import com.app.swagliv.model.Result;
import com.app.swagliv.viewmodel.store.StoreViewModel;
import com.app.swagliv.model.Success;

import java.util.ArrayList;

public class StoreProductDetailActivity extends AppCompatActivity implements View.OnClickListener {

    StoreViewModel storeViewModel;
    private AlertDialog mProgressbar;
    ActivityStoreProductDetailBinding activityStoreProductDetailBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityStoreProductDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_store_product_detail);

        storeViewModel = StoreViewModel.getInstance(getApplication());
        final OwnProduct ownProduct = (OwnProduct) getIntent().getSerializableExtra("product_detail");

        //display images
        final ArrayList<String> images = ownProduct.getProductImages();
        final ImagesAdapter imagesAdapter = new ImagesAdapter(images);
        activityStoreProductDetailBinding.recyclerviewImages.setAdapter(imagesAdapter);
        activityStoreProductDetailBinding.recyclerviewImages.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        new PagerSnapHelper().attachToRecyclerView(activityStoreProductDetailBinding.recyclerviewImages);

        if(imagesAdapter.getItemCount()>1){
            activityStoreProductDetailBinding.recyclerviewIndicator.setAdapter(new ProgressIndicatorAdapter(images.size()));
            activityStoreProductDetailBinding.recyclerviewIndicator.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
            new PagerSnapHelper().attachToRecyclerView(activityStoreProductDetailBinding.recyclerviewIndicator);
            activityStoreProductDetailBinding.recyclerviewIndicator.addItemDecoration(new RecyclerView.ItemDecoration() {
                @Override
                public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                    int position = parent.getChildAdapterPosition(view);
                    int lastPosition = parent.getAdapter().getItemCount()-1;
                    if(position!=lastPosition) {
                        outRect.right = getResources().getDimensionPixelSize(R.dimen.dp16);
                    }
                }
            });
            activityStoreProductDetailBinding.recyclerviewIndicator.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    ProgressIndicatorAdapter progressIndicatorAdapter = (ProgressIndicatorAdapter) activityStoreProductDetailBinding.recyclerviewIndicator.getAdapter();
                    progressIndicatorAdapter.setCurrentPosition(layoutManager.findFirstCompletelyVisibleItemPosition());
                }
            });
        }

        //display product name
        final String productName = ownProduct.getProductName();
        activityStoreProductDetailBinding.textviewProductName.setText(productName);

        //display coins
        activityStoreProductDetailBinding.textviewCoins.setText(String.valueOf((int) ownProduct.getCoins()).concat(" "+getResources().getString(R.string.coins)));

        activityStoreProductDetailBinding.recyclerviewColor.setAdapter(new ColorsAdapter());
        activityStoreProductDetailBinding.recyclerviewColor.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        activityStoreProductDetailBinding.recyclerviewColor.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, int itemPosition, @NonNull RecyclerView parent) {
                outRect.right = getResources().getDimensionPixelSize(R.dimen.dp8);
            }
        });

        //display description
        final String description = ownProduct.getDescription();
        activityStoreProductDetailBinding.textviewDescription.setText(description);

        activityStoreProductDetailBinding.btnAddToCart.setOnClickListener(this);
        activityStoreProductDetailBinding.backBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add_to_cart:
                final OwnProduct ownProduct = (OwnProduct) getIntent().getSerializableExtra("product_detail");
                storeViewModel.addItemToCart(ownProduct.get_id()).observe(this,new Observer<Result>(){
                    @Override
                    public void onChanged(Result result) {
                        if (result instanceof Loading) {
                            mProgressbar = new LoadingProgressBarDialog.Builder()
                                    .setContext(StoreProductDetailActivity.this)
                                    .setMessage(getString(R.string.please_wait))
                                    .build();
                            mProgressbar.show();
                        } else if(result instanceof Success){
                            Success<String> data = (Success<String>) result;
                            Toast.makeText(StoreProductDetailActivity.this,data.getData(),Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(StoreProductDetailActivity.this,ShoppingCartActivity.class));
                            mProgressbar.dismiss();
                        } else if (result instanceof Error) {
                            mProgressbar.dismiss();
                            Error error = (Error) result;
                            Utility.showToast(getApplicationContext(),error.getException().getMessage());
                        }
                    }
                });
                break;
            case R.id.back_btn:
                finish();
                break;
        }
    }
}
