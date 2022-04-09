package com.app.swagliv.view.activities;

import static net.alhazmy13.mediapicker.Image.ImagePicker.EXTRA_IMAGE_PATH;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.swagliv.R;
import com.app.swagliv.constant.AppConstant;
import com.app.swagliv.databinding.ActivityAddProductImagesBinding;
import com.app.swagliv.view.adaptor.AddProductImagesAdapter;
import com.app.swagliv.viewmodel.store.StoreViewModel;

import net.alhazmy13.mediapicker.Image.ImagePicker;

import java.util.ArrayList;

public class AddProductImagesActivity extends AppCompatActivity implements View.OnClickListener {

    private final AddProductImagesAdapter addProductImagesAdapter = new AddProductImagesAdapter(this);
    private StoreViewModel storeViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityAddProductImagesBinding activityAddProductImagesBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_add_product_images);

        activityAddProductImagesBinding.EditHeader.backBtn.setOnClickListener(this);
        activityAddProductImagesBinding
                .EditHeader
                .headerTitle
                .setText(getResources().getString(R.string.title_add_product));
        activityAddProductImagesBinding
                .recyclerview
                .setAdapter(addProductImagesAdapter);
        activityAddProductImagesBinding
                .recyclerview
                .setLayoutManager(new GridLayoutManager(this, 3));
        activityAddProductImagesBinding
                .recyclerview
                .addItemDecoration(new RecyclerView.ItemDecoration() {
                    @Override
                    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                        outRect.top = getResources().getDimensionPixelSize(R.dimen.dp24);
                        outRect.left = getResources().getDimensionPixelSize(R.dimen.dp20);
                        outRect.right = getResources().getDimensionPixelSize(R.dimen.dp20);
                    }
                });
        activityAddProductImagesBinding
                .passionBtnContinue
                .setOnClickListener(this);
        storeViewModel = StoreViewModel.getInstance(getApplication());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case AppConstant.RequestCodes.CAMERA:
                case AppConstant.RequestCodes.GALLERY:
                    addProductImagesAdapter.setImage(data.getStringArrayListExtra(EXTRA_IMAGE_PATH).get(0));
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_gallery:
                new ImagePicker.Builder(this)
                        .mode(ImagePicker.Mode.GALLERY)
                        .compressLevel(ImagePicker.ComperesLevel.MEDIUM)
                        .extension(ImagePicker.Extension.PNG)
                        .setRequestCode(AppConstant.RequestCodes.GALLERY)
                        .scale(600, 600)
                        .allowMultipleImages(false)
                        .enableDebuggingMode(false)
                        .build();
                break;
            case R.id.layout_camera:
                new ImagePicker.Builder(this)
                        .mode(ImagePicker.Mode.CAMERA)
                        .compressLevel(ImagePicker.ComperesLevel.MEDIUM)
                        .extension(ImagePicker.Extension.PNG)
                        .setRequestCode(AppConstant.RequestCodes.CAMERA)
                        .scale(600, 600)
                        .allowMultipleImages(false)
                        .enableDebuggingMode(false)
                        .build();
                break;
            case R.id.passion_btn_continue:
                final ArrayList<String> images = addProductImagesAdapter.getImages();
                getIntent().putExtra("images",images);
                startActivity(getIntent().setClass(this,ImagePreviewActivity.class));
                break;
            case R.id.back_btn:
                finish();
                break;
        }

    }
}
