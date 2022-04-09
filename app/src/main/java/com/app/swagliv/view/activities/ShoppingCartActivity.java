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
import com.app.swagliv.databinding.ActivityShoppingCartBinding;
import com.app.swagliv.model.Error;
import com.app.swagliv.model.Loading;
import com.app.swagliv.model.store.CartProduct;
import com.app.swagliv.view.adaptor.ShoppingtCartAdapter;
import com.app.swagliv.view.fragment.SomeOneElseShoppingBottomSheetFragment;
import com.app.swagliv.model.Result;
import com.app.swagliv.viewmodel.store.StoreViewModel;
import com.app.swagliv.model.Success;

import java.util.ArrayList;

public class ShoppingCartActivity extends AppCompatActivity implements View.OnClickListener {

    StoreViewModel storeViewModel;
    ActivityShoppingCartBinding activityShoppingCartBinding;
    private AlertDialog mProgressbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityShoppingCartBinding = DataBindingUtil.setContentView(this, R.layout.activity_shopping_cart);
        storeViewModel = StoreViewModel.getInstance(getApplication());
        activityShoppingCartBinding.EditHeader.headerTitle.setText(getResources().getString(R.string.shopping_cart));
        activityShoppingCartBinding.EditHeader.btnFilter.setImageResource(R.drawable.ic_cart);
        activityShoppingCartBinding.EditHeader.backBtn.setOnClickListener(this);
        storeViewModel.getAllCartProducts().observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result result) {
                if (result instanceof Loading) {
                    mProgressbar = new LoadingProgressBarDialog.Builder()
                            .setContext(ShoppingCartActivity.this)
                            .setMessage(getString(R.string.please_wait))
                            .build();
                    mProgressbar.show();
                } else if (result instanceof Success) {
                    Success<ArrayList<CartProduct>> cartProducts = (Success<ArrayList<CartProduct>>) result;
                    activityShoppingCartBinding
                            .recyclerview
                            .setAdapter(new ShoppingtCartAdapter(ShoppingCartActivity.this));
                    activityShoppingCartBinding
                            .recyclerview
                            .setLayoutManager(new LinearLayoutManager(ShoppingCartActivity.this));
                    activityShoppingCartBinding
                            .recyclerview
                            .addItemDecoration(new RecyclerView.ItemDecoration() {
                                @Override
                                public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                                    outRect.top = getResources().getDimensionPixelSize(R.dimen.dp24);
                                    outRect.left = getResources().getDimensionPixelSize(R.dimen.dp20);
                                    outRect.right = getResources().getDimensionPixelSize(R.dimen.dp20);
                                }
                            });
                    final ShoppingtCartAdapter shoppingtCartAdapter =
                            (ShoppingtCartAdapter) activityShoppingCartBinding
                            .recyclerview
                            .getAdapter();
                    shoppingtCartAdapter.submitList(cartProducts.getData());
                    mProgressbar.dismiss();
                } else if (result instanceof Error) {
                    mProgressbar.dismiss();
                    Error error = (Error) result;
                    Utility.showToast(getApplicationContext(),error.getException().getMessage());
                }
            }
        });
        activityShoppingCartBinding.btnCheckout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageview_delete:
                final CartProduct cartProduct = (CartProduct) v.getTag(R.string.tag_my_cart_product);
                storeViewModel.removeProductFromCart(cartProduct).observe(this, new Observer<Result>() {
                    @Override
                    public void onChanged(Result result) {
                        if (result instanceof Loading) {
                            mProgressbar = new LoadingProgressBarDialog.Builder()
                                    .setContext(ShoppingCartActivity.this)
                                    .setMessage(getString(R.string.please_wait))
                                    .build();
                            mProgressbar.show();
                        } else if (result instanceof Success) {
                            Success<ArrayList<CartProduct>> success = (Success<ArrayList<CartProduct>>) result;
                            ShoppingtCartAdapter shoppingtCartAdapter = (ShoppingtCartAdapter) activityShoppingCartBinding.recyclerview.getAdapter();
                            shoppingtCartAdapter.submitList(success.getData());
                            mProgressbar.dismiss();
                        } else if (result instanceof Error) {
                            mProgressbar.dismiss();
                            Error error = (Error) result;
                            Utility.showToast(getApplicationContext(),error.getException().getMessage());
                        }
                    }
                });
                break;
            case R.id.btn_checkout:
                ShoppingtCartAdapter shoppingtCartAdapter = (ShoppingtCartAdapter) activityShoppingCartBinding.recyclerview.getAdapter();
                ArrayList<CartProduct> cartProducts = shoppingtCartAdapter.getItems();
                storeViewModel.isCartNotEmpty(cartProducts).observe(this, new Observer<Result>() {
                    @Override
                    public void onChanged(Result result) {
                        if(result instanceof Success){
                            final Intent intent = new Intent(ShoppingCartActivity.this,DeliveryAddressActivity.class);
                            intent.putExtra("cartproducts",cartProducts);
                            startActivity(intent);
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
