package com.app.swagliv.view.activities;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.swagliv.R;
import com.app.swagliv.databinding.ActivityMyOrderBinding;
import com.app.swagliv.model.Result;
import com.app.swagliv.model.Success;
import com.app.swagliv.model.store.Order;
import com.app.swagliv.view.adaptor.MyOrderAdapter;
import com.app.swagliv.viewmodel.store.StoreViewModel;

import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity implements View.OnClickListener {

    StoreViewModel storeViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMyOrderBinding activityMyOrderBinding = DataBindingUtil.setContentView(this,R.layout.activity_my_order);
        activityMyOrderBinding.EditHeader.headerTitle.setText(getResources().getString(R.string.my_order));
        activityMyOrderBinding.EditHeader.backBtn.setOnClickListener(this);
        storeViewModel = StoreViewModel.getInstance(getApplication());

        storeViewModel.getAllBookedOrders().observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result result) {
                if(result instanceof Success){
                    Success<ArrayList<Order>> orders = (Success<ArrayList<Order>>) result;
                    activityMyOrderBinding
                            .recyclerview
                            .setAdapter(new MyOrderAdapter(orders.getData(),MyOrderActivity.this));
                    activityMyOrderBinding
                            .recyclerview
                            .setLayoutManager(new LinearLayoutManager(MyOrderActivity.this));
                    activityMyOrderBinding
                            .recyclerview
                            .addItemDecoration(new RecyclerView.ItemDecoration() {
                                @Override
                                public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                                    outRect.top = getResources().getDimensionPixelSize(R.dimen.dp16);
                                    outRect.left = getResources().getDimensionPixelSize(R.dimen.dp16);
                                    outRect.right = getResources().getDimensionPixelSize(R.dimen.dp16);
                                }
                            });
                }
            }
        });
    }

    @Override
    public void finish() {
        startActivity(new Intent(this,DashboardActivity.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.item:
                Intent intent = new Intent(this,MyOrderDetailActivity.class);
                intent.putExtra("order_detail",(Order)v.getTag(R.string.tag_selected_order));
                startActivity(intent);
                break;
            case R.id.back_btn:
                finish();
                break;
        }
    }


}
