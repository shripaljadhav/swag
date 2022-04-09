package com.app.swagliv.view.activities;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
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
import com.app.swagliv.databinding.ActivityImagePreviewScreenBinding;
import com.app.swagliv.model.Error;
import com.app.swagliv.model.Loading;
import com.app.swagliv.view.adaptor.ImagesAdapter;
import com.app.swagliv.view.adaptor.ProgressIndicatorAdapter;
import com.app.swagliv.model.Result;
import com.app.swagliv.viewmodel.store.StoreViewModel;
import com.app.swagliv.model.Success;

import java.util.ArrayList;

public class ImagePreviewActivity extends AppCompatActivity implements View.OnClickListener {

    private StoreViewModel storeViewModel;
    private AlertDialog mProgressbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityImagePreviewScreenBinding activityStoreBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_image_preview_screen);

        activityStoreBinding.backBtn.setOnClickListener(this);
        ArrayList<String> images = (ArrayList<String>) getIntent().getSerializableExtra("images");
        final ImagesAdapter imagesAdapter = new ImagesAdapter(images);
        final RecyclerView recyclerViewImages = findViewById(R.id.recyclerview_images);
        recyclerViewImages.setAdapter(imagesAdapter);
        recyclerViewImages.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        new PagerSnapHelper().attachToRecyclerView(recyclerViewImages);

        if(imagesAdapter.getItemCount()>1){
            final RecyclerView recyclerViewIndicator = findViewById(R.id.recyclerview_indicator);
            recyclerViewIndicator.setAdapter(new ProgressIndicatorAdapter(images.size()));
            recyclerViewIndicator.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
            new PagerSnapHelper().attachToRecyclerView(recyclerViewIndicator);
            recyclerViewIndicator.addItemDecoration(new RecyclerView.ItemDecoration() {
                @Override
                public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                    int position = parent.getChildAdapterPosition(view);
                    int lastPosition = parent.getAdapter().getItemCount()-1;
                    if(position!=lastPosition) {
                        outRect.right = getResources().getDimensionPixelSize(R.dimen.dp16);
                    }
                }
            });
            recyclerViewImages.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    ProgressIndicatorAdapter progressIndicatorAdapter = (ProgressIndicatorAdapter) recyclerViewIndicator.getAdapter();
                    progressIndicatorAdapter.setCurrentPosition(layoutManager.findFirstCompletelyVisibleItemPosition());
                }
            });
        }

        final String productName = getIntent().getStringExtra("productName");
        activityStoreBinding.textviewProductName.setText(productName);

        final String coin = getIntent().getStringExtra("coin");
        activityStoreBinding.textviewCoins.setText(String.valueOf(coin).concat(" "+getResources().getString(R.string.coins)));

        final String description = getIntent().getStringExtra("description");
        activityStoreBinding.textviewDescription.setText(description);

        final String specification = getIntent().getStringExtra("specification");
        activityStoreBinding.textviewSpecification.setText(specification);

        activityStoreBinding.passionBtnContinue.setOnClickListener(this);
        storeViewModel = StoreViewModel.getInstance(getApplication());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.passion_btn_continue:
                final ArrayList<String> images = (ArrayList<String>) getIntent().getSerializableExtra("images");
                final String description = getIntent().getStringExtra("description");
                final String specification = getIntent().getStringExtra("specification");
                final String coin = getIntent().getStringExtra("coin");
                final String productName = getIntent().getStringExtra("productName");
                final String category = getIntent().getStringExtra("category");
                final String subCategory = getIntent().getStringExtra("subCategory");
                final ArrayList<String> colors = (ArrayList<String>) getIntent().getSerializableExtra("colors");
                storeViewModel.createProducts(images, description, specification, coin, productName, category, subCategory, colors).observe(this, new Observer<Result>() {
                    @Override
                    public void onChanged(Result result) {
                        if (result instanceof Loading) {
                            mProgressbar = new LoadingProgressBarDialog.Builder()
                                    .setContext(ImagePreviewActivity.this)
                                    .setMessage(getString(R.string.please_wait))
                                    .build();
                            mProgressbar.show();
                        } else if (result instanceof Success) {
                            Success<String> success = (Success<String>) result;
                            Toast.makeText(ImagePreviewActivity.this, success.getData(), Toast.LENGTH_LONG).show();
                            startActivity(new Intent(ImagePreviewActivity.this, ProductListingActivity.class));
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
