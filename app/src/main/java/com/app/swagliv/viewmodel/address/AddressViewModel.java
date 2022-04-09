package com.app.swagliv.viewmodel.address;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.app.swagliv.R;
import com.app.swagliv.model.Error;
import com.app.swagliv.model.Loading;
import com.app.swagliv.model.Result;
import com.app.swagliv.model.Success;
import com.app.swagliv.model.address.AddressList;
import com.app.swagliv.model.address.AddressRequest;
import com.app.swagliv.model.address.AddressResponse;
import com.app.swagliv.model.address.GetAddressResponse;
import com.app.swagliv.network.ApplicationRetrofitServices;
import com.app.swagliv.viewmodel.address.datasource.IAddressDataSource;
import com.app.swagliv.viewmodel.address.repository.AddressRepositoryImpl;
import com.app.swagliv.viewmodel.address.repository.IAddressRepository;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public final class AddressViewModel extends AndroidViewModel {

    private static AddressViewModel addressViewModel;
    private final IAddressRepository addressRepository;
    private Application application;

    public AddressViewModel(@NonNull Application application, IAddressRepository addressRepository) {
        super(application);
        this.addressRepository = addressRepository;
        this.application = application;
    }

    public static AddressViewModel getInstance(Application application) {
        if (addressViewModel == null) {
            final IAddressDataSource iAddressDataSource = ApplicationRetrofitServices.getInstance().getAddressService();
            addressViewModel = new AddressViewModel(application, new AddressRepositoryImpl(iAddressDataSource));
        }
        return addressViewModel;
    }

    public LiveData<Result> saveAddress(final String name,
                                        final String mobileNumber,
                                        final String alternateMobileNumber,
                                        final String doorNumberAndBuildingName,
                                        final String streetName,
                                        final String city,
                                        final String pincode,
                                        final String state,
                                        final String landmark) {
        return new MutableLiveData<Result>() {
            {
                try {
                    if (name == null || name.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_valid_name));
                    }
                    if (mobileNumber == null || mobileNumber.isEmpty() || mobileNumber.length() != 10) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_valid_phone_number));
                    }
                    if (alternateMobileNumber == null || alternateMobileNumber.isEmpty() || alternateMobileNumber.length() != 10) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_valid_alternate_phone_number));
                    }
                    if (pincode == null || pincode.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_valid_pincode));
                    }
                    if (state == null || state.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_valid_state));
                    }
                    if (city == null || city.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_valid_city));
                    }
                    if (doorNumberAndBuildingName == null || doorNumberAndBuildingName.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_house_no_and_building_name));
                    }
                    if (streetName == null || streetName.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_road_name_and_area_colony));
                    }
                    if (landmark == null || landmark.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_valid_landmark));
                    }
                    addressRepository.saveAddress(new AddressRequest(new AddressList(
                            name,
                            mobileNumber,
                            alternateMobileNumber,
                            doorNumberAndBuildingName,
                            streetName,
                            city,
                            pincode,
                            state,
                            landmark,
                            null)))
                            .subscribeOn(Schedulers.io())
                            .observeOn(Schedulers.io())
                            .subscribe(new Observer<AddressResponse>() {
                                @Override
                                public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                                }

                                @Override
                                public void onNext(@io.reactivex.rxjava3.annotations.NonNull AddressResponse addressResponse) {
                                    postValue(new Success(addressResponse.getMessage()));
                                }

                                @Override
                                public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                                    postValue(new Error(new Exception(getApplication().getString(R.string.api_failure_error_msg))));
                                }

                                @Override
                                public void onComplete() {

                                }
                            });
                } catch (Exception e) {
                    setValue(new Error(e));
                }
            }
        };
    }

    public LiveData<Result> getAllAddress(){
        return new MutableLiveData<Result>(){
            {
                setValue(new Loading());
                addressRepository.getAllAddress()
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .subscribe(new Observer<GetAddressResponse>() {
                            @Override
                            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@io.reactivex.rxjava3.annotations.NonNull GetAddressResponse getAddressResponse) {
                                postValue(new Success(getAddressResponse.getData().getAddressList()));
                            }

                            @Override
                            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                                postValue(new Error(new Exception(getApplication().getString(R.string.api_failure_error_msg))));
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        };
    }

    public LiveData<Result> editAddress(final String name,
                                        final String mobileNumber,
                                        final String alternateMobileNumber,
                                        final String doorNumberAndBuildingName,
                                        final String streetName,
                                        final String city,
                                        final String pincode,
                                        final String state,
                                        final String landmark,
                                        String addressId) {
        return new MutableLiveData<Result>() {
            {
                try {
                    setValue(new Loading());
                    if (name == null || name.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_valid_name));
                    }
                    if (mobileNumber == null || mobileNumber.isEmpty() || mobileNumber.length() != 10) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_valid_phone_number));
                    }
                    if (alternateMobileNumber == null || alternateMobileNumber.isEmpty() || alternateMobileNumber.length() != 10) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_valid_alternate_phone_number));
                    }
                    if (pincode == null || pincode.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_valid_pincode));
                    }
                    if (state == null || state.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_valid_state));
                    }
                    if (city == null || city.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_valid_city));
                    }
                    if (doorNumberAndBuildingName == null || doorNumberAndBuildingName.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_house_no_and_building_name));
                    }
                    if (streetName == null || streetName.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_road_name_and_area_colony));
                    }
                    if (landmark == null || landmark.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_valid_landmark));
                    }
                    addressRepository.editAddress(new AddressRequest(new AddressList(
                            name,
                            mobileNumber,
                            alternateMobileNumber,
                            doorNumberAndBuildingName,
                            streetName,
                            city,
                            pincode,
                            state,
                            landmark,
                            addressId)))
                            .subscribeOn(Schedulers.io())
                            .observeOn(Schedulers.io())
                            .subscribe(new Observer<AddressResponse>() {
                                @Override
                                public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                                }

                                @Override
                                public void onNext(@io.reactivex.rxjava3.annotations.NonNull AddressResponse addressResponse) {
                                    postValue(new Success<String>(addressResponse.getMessage()));
                                }

                                @Override
                                public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                                    postValue(new Error(new Exception(getApplication().getString(R.string.api_failure_error_msg))));
                                }

                                @Override
                                public void onComplete() {

                                }
                            });
                } catch (Exception e) {
                    setValue(new Error(e));
                }
            }
        };
    }

    public LiveData<Result> isAddressSelected(AddressList selectedItem) {
        return new MutableLiveData<Result>(){
            {
                if(selectedItem!=null){
                    setValue(new Success<AddressList>(selectedItem));
                }else {
                    setValue(new Error(new Exception(application.getResources().getString(R.string.error_select_address))));
                }
            }
        };
    }
}
