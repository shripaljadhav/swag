package com.app.swagliv.view.activities;

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
import com.app.swagliv.databinding.ActivityCreateAddressBinding;
import com.app.swagliv.model.Error;
import com.app.swagliv.model.Loading;
import com.app.swagliv.model.Result;
import com.app.swagliv.model.Success;
import com.app.swagliv.viewmodel.address.AddressViewModel;

public class CreateAddressActivity extends AppCompatActivity implements View.OnClickListener {

    AddressViewModel addressViewModel;
    ActivityCreateAddressBinding activityCreateAddressBinding;
    private AlertDialog mProgressbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCreateAddressBinding = DataBindingUtil.setContentView(this, R.layout.activity_create_address);
        activityCreateAddressBinding.EditHeader.headerTitle.setText(getResources().getString(R.string.title_add_delivery_address));
        activityCreateAddressBinding.btnNext.setOnClickListener(this);
        addressViewModel = AddressViewModel.getInstance(getApplication());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                addressViewModel.saveAddress(
                        activityCreateAddressBinding.edittextName.getText().toString().trim(),
                        activityCreateAddressBinding.edittextPhoneNumber.getText().toString().trim(),
                        activityCreateAddressBinding.edittextAlternatePhoneNumber.getText().toString().trim(),
                        activityCreateAddressBinding.edittextHouseNoBuildingName.getText().toString().trim(),
                        activityCreateAddressBinding.edittextRoadNameAreaColony.getText().toString().trim(),
                        activityCreateAddressBinding.spinnerCity.getText().toString().trim(),
                        activityCreateAddressBinding.edittextPincode.getText().toString().trim(),
                        activityCreateAddressBinding.spinnerState.getText().toString().trim(),
                        activityCreateAddressBinding.edittextLandmark.getText().toString().trim()
                ).observe(this, result -> {
                    if (result instanceof Loading) {
                        mProgressbar = new LoadingProgressBarDialog.Builder()
                                .setContext(CreateAddressActivity.this)
                                .setMessage(getString(R.string.please_wait))
                                .build();
                        mProgressbar.show();
                    } else if(result instanceof Success){
                        Success<String> success = (Success) result;
                        Toast.makeText(CreateAddressActivity.this,success.getData(),Toast.LENGTH_LONG).show();
                        finish();
                        mProgressbar.dismiss();
                    } else if (result instanceof Error) {
                        mProgressbar.dismiss();
                        Error error = (Error) result;
                        Utility.showToast(getApplicationContext(),error.getException().getMessage());
                    }
                });
                break;
        }
    }
}
