package com.app.swagliv.view.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.common.utils.Utility;
import com.app.progressbar.LoadingProgressBarDialog;
import com.app.swagliv.R;
import com.app.swagliv.databinding.BottomsheetFilterBinding;
import com.app.swagliv.model.Error;
import com.app.swagliv.model.Loading;
import com.app.swagliv.model.store.Category;
import com.app.swagliv.model.store.OwnProduct;
import com.app.swagliv.view.FilterListener;
import com.app.swagliv.view.activities.AddProductActivity;
import com.app.swagliv.view.adaptor.CategoryAdapter;
import com.app.swagliv.view.adaptor.SubCategoryAdapter;
import com.app.swagliv.model.Result;
import com.app.swagliv.viewmodel.store.StoreViewModel;
import com.app.swagliv.model.Success;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class FilterBottomSheetFragment extends BottomSheetDialogFragment implements View.OnClickListener {

    private BottomsheetFilterBinding bottomsheetFilterBinding;
    private StoreViewModel storeViewModel;
    private AlertDialog mProgressbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bottomsheetFilterBinding = BottomsheetFilterBinding.inflate(inflater, container, false);
        return bottomsheetFilterBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            storeViewModel = StoreViewModel.getInstance(requireActivity().getApplication());
            storeViewModel.getAllCategories().observe(this, result -> {
                if (result instanceof Loading) {
                    mProgressbar = new LoadingProgressBarDialog.Builder()
                            .setContext(getActivity())
                            .setMessage(getString(R.string.please_wait))
                            .build();
                    mProgressbar.show();
                } else if (result instanceof Success) {
                    Success<ArrayList<Category>> success = (Success<ArrayList<Category>>) result;
                    ArrayList<Category> list = success.getData();
                    CategoryAdapter categoryAdapter = new CategoryAdapter(list, FilterBottomSheetFragment.this);
                    bottomsheetFilterBinding.recyclerviewCategory.setAdapter(categoryAdapter);
                    bottomsheetFilterBinding.recyclerviewCategory.setLayoutManager(new GridLayoutManager(getActivity(), 5));
                    bottomsheetFilterBinding
                            .recyclerviewCategory
                            .addItemDecoration(new RecyclerView.ItemDecoration() {
                                @Override
                                public void getItemOffsets(@NonNull Rect outRect, @NonNull View view1, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                                    outRect.top = getResources().getDimensionPixelSize(R.dimen.dp4);
                                    outRect.left = getResources().getDimensionPixelSize(R.dimen.dp4);
                                    outRect.right = getResources().getDimensionPixelSize(R.dimen.dp4);
                                }
                            });

                    SubCategoryAdapter subCategoryAdapter = new SubCategoryAdapter(list, FilterBottomSheetFragment.this);
                    bottomsheetFilterBinding.recyclerviewSubCategory.setAdapter(subCategoryAdapter);
                    bottomsheetFilterBinding.recyclerviewSubCategory.setLayoutManager(new GridLayoutManager(getActivity(), 5));
                    bottomsheetFilterBinding
                            .recyclerviewSubCategory
                            .addItemDecoration(new RecyclerView.ItemDecoration() {
                                @Override
                                public void getItemOffsets(@NonNull Rect outRect, @NonNull View view1, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                                    outRect.top = getResources().getDimensionPixelSize(R.dimen.dp4);
                                    outRect.left = getResources().getDimensionPixelSize(R.dimen.dp4);
                                    outRect.right = getResources().getDimensionPixelSize(R.dimen.dp4);
                                }
                            });
                    mProgressbar.dismiss();
                } else if (result instanceof Error) {
                    mProgressbar.dismiss();
                    Error error = (Error) result;
                    Utility.showToast(getActivity(),error.getException().getMessage());
                }
            });
            bottomsheetFilterBinding.btnNext.setOnClickListener(this);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_category:
                Category category = (Category) v.getTag(R.string.tag_category);
                CategoryAdapter categoryAdapter = (CategoryAdapter) bottomsheetFilterBinding.recyclerviewCategory.getAdapter();
                categoryAdapter.setSelected(category);
                break;
            case R.id.layout_sub_category:
                Category subCategory = (Category) v.getTag(R.string.tag_category);
                SubCategoryAdapter subCategoryAdapter = (SubCategoryAdapter) bottomsheetFilterBinding.recyclerviewSubCategory.getAdapter();
                subCategoryAdapter.setSelected(subCategory);
                break;
            case R.id.btn_next:
                CategoryAdapter selectedCategoryAdapter = (CategoryAdapter) bottomsheetFilterBinding.recyclerviewCategory.getAdapter();
                Category selectedCategory = selectedCategoryAdapter.getSelectedCategory();
                SubCategoryAdapter selectedSubCategoryAdapter = (SubCategoryAdapter) bottomsheetFilterBinding.recyclerviewSubCategory.getAdapter();
                Category selectedSubCategory = selectedSubCategoryAdapter.getSelectedCategory();
                Float floats = bottomsheetFilterBinding.coinRange.getValues().get(0);
                ArrayList<OwnProduct> ownProducts = (ArrayList<OwnProduct>) getArguments().getSerializable("products");
                storeViewModel.searchProductsByFilter(selectedCategory, selectedSubCategory, floats, ownProducts).observe(getViewLifecycleOwner(), new Observer<Result>() {
                    @Override
                    public void onChanged(Result result) {
                        if(result instanceof Success){
                            Success<ArrayList<OwnProduct>> success = (Success) result;
                            FilterListener filterListener = (FilterListener) getActivity();
                            filterListener.filteredResult(success.getData());
                            dismiss();
                        }else {
                          dismiss();
                        }
                    }
                });
                break;
        }
    }
}
