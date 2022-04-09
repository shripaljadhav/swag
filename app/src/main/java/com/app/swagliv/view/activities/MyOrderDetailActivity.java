package com.app.swagliv.view.activities;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.app.swagliv.R;
import com.app.swagliv.databinding.ActivityMyOrderDetailBinding;
import com.app.swagliv.model.store.Order;
import com.app.swagliv.view.adaptor.ColorsAdapter;
import com.app.swagliv.view.adaptor.ImagesAdapter;
import com.app.swagliv.view.adaptor.ProgressIndicatorAdapter;

import java.util.ArrayList;

public class MyOrderDetailActivity extends AppCompatActivity {

    ActivityMyOrderDetailBinding activityMyOrderDetailBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMyOrderDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_my_order_detail);

        final Order ownProduct = (Order) getIntent().getSerializableExtra("order_detail");

        //display images
        final ArrayList<String> images = ownProduct.getProductImages();
        final ImagesAdapter imagesAdapter = new ImagesAdapter(images);
        activityMyOrderDetailBinding.recyclerviewImages.setAdapter(imagesAdapter);
        activityMyOrderDetailBinding.recyclerviewImages.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        new PagerSnapHelper().attachToRecyclerView(activityMyOrderDetailBinding.recyclerviewImages);

        if(imagesAdapter.getItemCount()>1){
            activityMyOrderDetailBinding.recyclerviewIndicator.setAdapter(new ProgressIndicatorAdapter(images.size()));
            activityMyOrderDetailBinding.recyclerviewIndicator.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
            new PagerSnapHelper().attachToRecyclerView(activityMyOrderDetailBinding.recyclerviewIndicator);
            activityMyOrderDetailBinding.recyclerviewIndicator.addItemDecoration(new RecyclerView.ItemDecoration() {
                @Override
                public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                    int position = parent.getChildAdapterPosition(view);
                    int lastPosition = parent.getAdapter().getItemCount()-1;
                    if(position!=lastPosition) {
                        outRect.right = getResources().getDimensionPixelSize(R.dimen.dp16);
                    }
                }
            });
            activityMyOrderDetailBinding.recyclerviewIndicator.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    ProgressIndicatorAdapter progressIndicatorAdapter = (ProgressIndicatorAdapter) activityMyOrderDetailBinding.recyclerviewIndicator.getAdapter();
                    progressIndicatorAdapter.setCurrentPosition(layoutManager.findFirstCompletelyVisibleItemPosition());
                }
            });
        }

        //display product name
        final String productName = ownProduct.getProductName();
        activityMyOrderDetailBinding.textviewProductName.setText(productName);

        //display coins
        activityMyOrderDetailBinding.textviewCoins.setText(String.valueOf((int) ownProduct.getCoins()).concat(" "+getResources().getString(R.string.coins)));

        activityMyOrderDetailBinding.recyclerviewColor.setAdapter(new ColorsAdapter());
        activityMyOrderDetailBinding.recyclerviewColor.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        activityMyOrderDetailBinding.recyclerviewColor.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, int itemPosition, @NonNull RecyclerView parent) {
                outRect.right = getResources().getDimensionPixelSize(R.dimen.dp8);
            }
        });

        //display description
        //final String description = ownProduct.getDescription();
       // activityMyOrderDetailBinding.textviewDescription.setText(description);

    }
}
