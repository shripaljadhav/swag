package com.app.swagliv.view.activities;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.app.swagliv.R;
import com.app.swagliv.databinding.ActivityShoppingForLoveBinding;
import com.app.swagliv.view.adaptor.ShoppingForLoveAdapter;

public class ShoppingForLoveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityShoppingForLoveBinding activityShoppingForLoveBinding = DataBindingUtil.setContentView(this,R.layout.activity_shopping_for_love);
        activityShoppingForLoveBinding
                .recyclerview
                .setAdapter(new ShoppingForLoveAdapter());
        activityShoppingForLoveBinding
                .recyclerview
                .setLayoutManager(new LinearLayoutManager(this));
        activityShoppingForLoveBinding
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
