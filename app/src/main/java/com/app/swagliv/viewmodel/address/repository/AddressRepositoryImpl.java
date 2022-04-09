package com.app.swagliv.viewmodel.address.repository;

import com.app.swagliv.model.address.AddressRequest;
import com.app.swagliv.model.address.AddressResponse;
import com.app.swagliv.model.address.GetAddressResponse;
import com.app.swagliv.viewmodel.address.datasource.IAddressDataSource;

import io.reactivex.rxjava3.core.Observable;

public class AddressRepositoryImpl implements IAddressRepository{

    private final IAddressDataSource iAddressDataSource;

    public AddressRepositoryImpl(IAddressDataSource iAddressDataSource) {
        this.iAddressDataSource = iAddressDataSource;
    }

    @Override
    public Observable<AddressResponse> saveAddress(AddressRequest addressRequest) {
        return iAddressDataSource.saveAddress(addressRequest);
    }

    @Override
    public Observable<GetAddressResponse> getAllAddress() {
        return iAddressDataSource.getAllAddress();
    }

    @Override
    public Observable<AddressResponse> editAddress(AddressRequest addressRequest) {
        return iAddressDataSource.editAddress(addressRequest);
    }
}
