package com.app.swagliv.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.app.swagliv.databinding.BottomsheetShoppingCartBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ShoppingCartBottomSheetFragment extends BottomSheetDialogFragment {

    BottomsheetShoppingCartBinding bottomsheetShoppingCartBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bottomsheetShoppingCartBinding = BottomsheetShoppingCartBinding.inflate(inflater,container,false);
        return bottomsheetShoppingCartBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
