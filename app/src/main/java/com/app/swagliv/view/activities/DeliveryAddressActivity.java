package com.app.swagliv.view.activities;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

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
import com.app.swagliv.databinding.ActivityDeliveryAddressBinding;
import com.app.swagliv.model.Error;
import com.app.swagliv.model.Loading;
import com.app.swagliv.model.Result;
import com.app.swagliv.model.Success;
import com.app.swagliv.model.address.AddressList;
import com.app.swagliv.view.adaptor.AddressAdapter;
import com.app.swagliv.view.fragment.SomeOneElseShoppingBottomSheetFragment;
import com.app.swagliv.viewmodel.address.AddressViewModel;

import java.util.ArrayList;

public class DeliveryAddressActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    ActivityDeliveryAddressBinding activityDeliveryAddressBinding;
    AddressViewModel addressViewModel;
    private AlertDialog mProgressbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDeliveryAddressBinding = DataBindingUtil.setContentView(this, R.layout.activity_delivery_address);
        addressViewModel = AddressViewModel.getInstance(getApplication());
        addressViewModel.getAllAddress().observe(this, result -> {
            if (result instanceof Loading) {
                mProgressbar = new LoadingProgressBarDialog.Builder()
                        .setContext(DeliveryAddressActivity.this)
                        .setMessage(getString(R.string.please_wait))
                        .build();
                mProgressbar.show();
            } else if (result instanceof Success) {
                Success<ArrayList<AddressList>> success = (Success<ArrayList<AddressList>>) result;
                final AddressAdapter addressAdapter = new AddressAdapter(this, this);
                activityDeliveryAddressBinding.recyclerviewAddress.setAdapter(addressAdapter);
                activityDeliveryAddressBinding.recyclerviewAddress.setLayoutManager(new LinearLayoutManager(this));
                activityDeliveryAddressBinding
                        .recyclerviewAddress
                        .addItemDecoration(new RecyclerView.ItemDecoration() {
                            @Override
                            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                                outRect.top = getResources().getDimensionPixelSize(R.dimen.dp12);
                            }
                        });
                addressAdapter.submitList(success.getData());
                mProgressbar.dismiss();
            } else if (result instanceof Error) {
                mProgressbar.dismiss();
                Error error = (Error) result;
                Utility.showToast(getApplicationContext(), error.getException().getMessage());
            }
        });
        activityDeliveryAddressBinding.EditHeader.headerTitle.setText(getResources().getString(R.string.title_add_delivery_address));
        activityDeliveryAddressBinding.layoutAddNewAddress.setOnClickListener(this);
        activityDeliveryAddressBinding.btnProceed.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.isPressed()) {
            final AddressAdapter addressAdapter = (AddressAdapter) activityDeliveryAddressBinding.recyclerviewAddress.getAdapter();
            addressAdapter.setSelectedItem((Integer) buttonView.getTag(R.string.tag_selected_address_position));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textview_edit:
                final AddressList addressListItem = (AddressList) v.getTag(R.string.tag_selected_address);
                final Intent intent = new Intent(this, EditAddressActivity.class);
                intent.putExtra("addressListItem", addressListItem);
                startActivity(intent);
                break;
            case R.id.layout_add_new_address:
                startActivity(new Intent(this, CreateAddressActivity.class));
                break;
            case R.id.btn_proceed:
                final AddressAdapter addressAdapter = (AddressAdapter) activityDeliveryAddressBinding.recyclerviewAddress.getAdapter();
                addressViewModel.isAddressSelected(addressAdapter.getSelectedItem()).observe(this, new Observer<Result>() {
                    @Override
                    public void onChanged(Result result) {
                        if (result instanceof Success) {
                            Success<AddressList> data = (Success<AddressList>) result;
                            final Bundle bundle = new Bundle();
                            bundle.putSerializable("selected_address", data.getData());
                            bundle.putSerializable("cartproducts", getIntent().getSerializableExtra("cartproducts"));
                            SomeOneElseShoppingBottomSheetFragment someOneElseShoppingBottomSheetFragment = new SomeOneElseShoppingBottomSheetFragment();
                            someOneElseShoppingBottomSheetFragment.setArguments(bundle);
                            someOneElseShoppingBottomSheetFragment.show(getSupportFragmentManager(), null);
                        } else if (result instanceof Error) {
                            Error error = (Error) result;
                            Toast.makeText(DeliveryAddressActivity.this, error.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        addressViewModel.getAllAddress().observe(this, result -> {
            if (result instanceof Loading) {
                mProgressbar = new LoadingProgressBarDialog.Builder()
                        .setContext(DeliveryAddressActivity.this)
                        .setMessage(getString(R.string.please_wait))
                        .build();
                mProgressbar.show();
            } else if (result instanceof Success) {
                Success<ArrayList<AddressList>> success = (Success<ArrayList<AddressList>>) result;
                final AddressAdapter addressAdapter = (AddressAdapter) activityDeliveryAddressBinding.recyclerviewAddress.getAdapter();
                addressAdapter.submitList(success.getData());
                mProgressbar.dismiss();
            } else if (result instanceof Error) {
                mProgressbar.dismiss();
                Error error = (Error) result;
                Utility.showToast(getApplicationContext(), error.getException().getMessage());
            }
        });
    }

}
