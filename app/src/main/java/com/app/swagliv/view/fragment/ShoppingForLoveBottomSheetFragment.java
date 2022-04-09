package com.app.swagliv.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.app.swagliv.R;
import com.app.swagliv.databinding.BottomsheetForLoveBinding;
import com.app.swagliv.databinding.BottomsheetShoppingCartBinding;
import com.app.swagliv.view.activities.WalletActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ShoppingForLoveBottomSheetFragment extends BottomSheetDialogFragment implements View.OnClickListener {

    BottomsheetForLoveBinding bottomsheetForLoveBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bottomsheetForLoveBinding = BottomsheetForLoveBinding.inflate(inflater,container,false);
        return bottomsheetForLoveBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomsheetForLoveBinding.btnAddToCart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add_to_cart:
                startActivityForResult(new Intent(getActivity(), WalletActivity.class),0);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println();
    }
}
