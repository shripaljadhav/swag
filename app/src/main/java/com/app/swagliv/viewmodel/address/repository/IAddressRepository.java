package com.app.swagliv.viewmodel.address.repository;

import com.app.swagliv.model.address.AddressRequest;
import com.app.swagliv.model.address.AddressResponse;
import com.app.swagliv.model.address.GetAddressResponse;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

public interface IAddressRepository {

    Observable<AddressResponse> saveAddress(AddressRequest addressRequest);

    Observable<GetAddressResponse> getAllAddress();

    Observable<AddressResponse>  editAddress(AddressRequest addressRequest);
}
