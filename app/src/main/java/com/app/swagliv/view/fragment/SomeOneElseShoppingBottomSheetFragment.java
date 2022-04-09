package com.app.swagliv.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.app.swagliv.R;
import com.app.swagliv.databinding.BottomsheetSomeoneElseShoppingBinding;
import com.app.swagliv.model.Error;
import com.app.swagliv.model.Result;
import com.app.swagliv.model.Success;
import com.app.swagliv.model.address.AddressList;
import com.app.swagliv.model.store.CartProduct;
import com.app.swagliv.view.InSufficientWalletBalanceException;
import com.app.swagliv.view.activities.MyOrderActivity;
import com.app.swagliv.view.activities.ShoppingForLoveActivity;
import com.app.swagliv.view.activities.WalletActivity;
import com.app.swagliv.viewmodel.store.StoreViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class SomeOneElseShoppingBottomSheetFragment extends BottomSheetDialogFragment implements View.OnClickListener {

    BottomsheetSomeoneElseShoppingBinding bottomsheetSomeoneElseShoppingBinding;
    StoreViewModel storeViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bottomsheetSomeoneElseShoppingBinding = BottomsheetSomeoneElseShoppingBinding.inflate(inflater,container,false);
        return bottomsheetSomeoneElseShoppingBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        storeViewModel = StoreViewModel.getInstance(getActivity().getApplication());
        bottomsheetSomeoneElseShoppingBinding.passionBtnContinue.setOnClickListener(this);
        bottomsheetSomeoneElseShoppingBinding.btnMySelf.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.passion_btn_continue:
                startActivity(new Intent(getActivity(), ShoppingForLoveActivity.class));
                dismiss();
                break;
            case R.id.btn_my_self:
                AddressList addressList = (AddressList) getArguments().getSerializable("selected_address");
                ArrayList<CartProduct> cartProducts = (ArrayList<CartProduct>) getArguments().getSerializable("cartproducts");
                storeViewModel.isCoinAvailableToPurchaseProduct(cartProducts,addressList).observe(getViewLifecycleOwner(), new Observer<Result>() {
                    @Override
                    public void onChanged(Result result) {
                        if(result instanceof Success){
                             startActivity(new Intent(getActivity(), MyOrderActivity.class));
                        }else if(result instanceof Error){
                            Error error = (Error) result;
                            if(error.getException() instanceof InSufficientWalletBalanceException){
                                new ShoppingForLoveBottomSheetFragment().show(getActivity().getSupportFragmentManager(),null);
                            }
                        }
                    }
                });
                break;
        }
    }
}