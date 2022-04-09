package com.app.swagliv.view.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.app.common.utils.Utility;
import com.app.progressbar.LoadingProgressBarDialog;
import com.app.swagliv.R;
import com.app.swagliv.databinding.ActivityEditAddressBinding;
import com.app.swagliv.model.Error;
import com.app.swagliv.model.Loading;
import com.app.swagliv.model.Success;
import com.app.swagliv.model.address.AddressList;
import com.app.swagliv.viewmodel.address.AddressViewModel;

public class EditAddressActivity extends AppCompatActivity implements View.OnClickListener {

    AddressViewModel addressViewModel;
    ActivityEditAddressBinding activityEditAddressBinding;
    AddressList addressListItem;
    private AlertDialog mProgressbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityEditAddressBinding = DataBindingUtil.setContentView(this,R.layout.activity_edit_address);
        activityEditAddressBinding.EditHeader.headerTitle.setText(getResources().getString(R.string.title_edit_delivery_address));

        addressListItem = (AddressList) getIntent().getSerializableExtra("addressListItem");

        activityEditAddressBinding.edittextName.setText(addressListItem.getName());
        activityEditAddressBinding.edittextPhoneNumber.setText(addressListItem.getMobileNumber());
        activityEditAddressBinding.edittextAlternatePhoneNumber.setText(addressListItem.getAlternateMobileNumber());
        activityEditAddressBinding.edittextPincode.setText(addressListItem.getPincode());
        activityEditAddressBinding.spinnerState.setText(addressListItem.getState());
        activityEditAddressBinding.spinnerCity.setText(addressListItem.getCity());
        activityEditAddressBinding.edittextHouseNoBuildingName.setText(addressListItem.getDoorNumberAndBuildingName());
        activityEditAddressBinding.edittextRoadNameAreaColony.setText(addressListItem.getStreetName());
        activityEditAddressBinding.edittextLandmark.setText(addressListItem.getLandmark());

        addressViewModel = AddressViewModel.getInstance(getApplication());
        activityEditAddressBinding.btnNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                addressViewModel.editAddress(
                        activityEditAddressBinding.edittextName.getText().toString().trim(),
                        activityEditAddressBinding.edittextPhoneNumber.getText().toString().trim(),
                        activityEditAddressBinding.edittextAlternatePhoneNumber.getText().toString().trim(),
                        activityEditAddressBinding.edittextHouseNoBuildingName.getText().toString().trim(),
                        activityEditAddressBinding.edittextRoadNameAreaColony.getText().toString().trim(),
                        activityEditAddressBinding.spinnerCity.getText().toString().trim(),
                        activityEditAddressBinding.edittextPincode.getText().toString().trim(),
                        activityEditAddressBinding.spinnerState.getText().toString().trim(),
                        activityEditAddressBinding.edittextLandmark.getText().toString().trim(),
                        addressListItem.getAddressId()
                ).observe(this, result -> {
                    if (result instanceof Loading) {
                        mProgressbar = new LoadingProgressBarDialog.Builder()
                                .setContext(EditAddressActivity.this)
                                .setMessage(getString(R.string.please_wait))
                                .build();
                        mProgressbar.show();
                    } else if(result instanceof Success){
                        mProgressbar.dismiss();
                        Success<String> success = (Success) result;
                        Toast.makeText(EditAddressActivity.this,success.getData(),Toast.LENGTH_LONG).show();
                        finish();
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
