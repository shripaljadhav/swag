package com.app.swagliv.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import com.app.common.utils.Utility;
import com.app.progressbar.LoadingProgressBarDialog;
import com.app.swagliv.R;
import com.app.swagliv.databinding.ActivityAddProductBinding;
import com.app.swagliv.model.Loading;
import com.app.swagliv.model.store.Category;
import com.app.swagliv.view.adaptor.CategorySpinnerAdapter;
import com.app.swagliv.model.Error;
import com.app.swagliv.model.Result;
import com.app.swagliv.viewmodel.store.StoreViewModel;
import com.app.swagliv.model.Success;

import java.util.ArrayList;

public class AddProductActivity extends AppCompatActivity implements View.OnClickListener {

    private StoreViewModel storeViewModel;
    private ActivityAddProductBinding activityAddProductBinding;
    private CategorySpinnerAdapter categorySpinnerAdapter;
    private CategorySpinnerAdapter subCategorySpinnerAdapter;
    private AlertDialog mProgressbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddProductBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_product);
        activityAddProductBinding.EditHeader.headerTitle.setText(getResources().getString(R.string.title_add_product));
        activityAddProductBinding.EditHeader.backBtn.setOnClickListener(this);

        activityAddProductBinding.btnNext.setOnClickListener(this);
        storeViewModel = StoreViewModel.getInstance(getApplication());
        storeViewModel.getAllCategories().observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result result) {
                if (result instanceof Loading) {
                    mProgressbar = new LoadingProgressBarDialog.Builder()
                            .setContext(AddProductActivity.this)
                            .setMessage(getString(R.string.please_wait))
                            .build();
                    mProgressbar.show();
                } else if (result instanceof Success) {
                    Success<ArrayList<Category>> success = (Success<ArrayList<Category>>) result;
                    ArrayList<Category> list = success.getData();

                    categorySpinnerAdapter = new CategorySpinnerAdapter(activityAddProductBinding.spinnerCategory);
                    activityAddProductBinding.spinnerCategory.setSpinnerAdapter(categorySpinnerAdapter);
                    activityAddProductBinding.spinnerCategory.setItems(list);
                    activityAddProductBinding.spinnerCategory.setLifecycleOwner(AddProductActivity.this);

                    subCategorySpinnerAdapter = new CategorySpinnerAdapter(activityAddProductBinding.spinnerSubCategory);
                    activityAddProductBinding.spinnerSubCategory.setSpinnerAdapter(subCategorySpinnerAdapter);
                    activityAddProductBinding.spinnerSubCategory.setItems(list);
                    activityAddProductBinding.spinnerSubCategory.setLifecycleOwner(AddProductActivity.this);
                    mProgressbar.dismiss();
                } else if (result instanceof Error) {
                    mProgressbar.dismiss();
                    Error error = (Error) result;
                    Utility.showToast(getApplicationContext(),error.getException().getMessage());
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                final String description = activityAddProductBinding.edittextDescription.getText().toString().trim();
                final String specification = activityAddProductBinding.edittextSpecification.getText().toString().trim();
                final String coin = activityAddProductBinding.edittextCoin.getText().toString().trim();
                final String productName = activityAddProductBinding.edittextProductName.getText().toString().trim();
                final String category = storeViewModel.getCategory(categorySpinnerAdapter.getItems(), activityAddProductBinding.spinnerCategory.getSelectedIndex());
                final String subCategory = storeViewModel.getSubCategory(subCategorySpinnerAdapter.getItems(), activityAddProductBinding.spinnerSubCategory.getSelectedIndex());
                final ArrayList<String> colors = new ArrayList<String>();
                colors.add("brown");
                colors.add("black");
                storeViewModel
                        .proceedToImageUpload(category, subCategory, productName, coin, description, specification, colors)
                        .observe(this, result -> {
                            if (result instanceof Success) {
                                final Intent intent = new Intent(AddProductActivity.this, AddProductImagesActivity.class);
                                intent.putExtra("description", description);
                                intent.putExtra("specification", specification);
                                intent.putExtra("coin", coin);
                                intent.putExtra("productName", productName);
                                intent.putExtra("category", category);
                                intent.putExtra("subCategory", subCategory);
                                intent.putExtra("colors", colors);
                                startActivity(intent);
                            }
                            else if (result instanceof Error) {
                                Error error = (Error) result;
                                Toast.makeText(AddProductActivity.this, error.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
                break;
            case R.id.back_btn:
                finish();
                break;
        }
    }

}
