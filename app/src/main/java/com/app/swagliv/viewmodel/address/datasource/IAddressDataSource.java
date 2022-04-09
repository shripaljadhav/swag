package com.app.swagliv.viewmodel.address.datasource;

import com.app.swagliv.model.address.AddressRequest;
import com.app.swagliv.model.address.AddressResponse;
import com.app.swagliv.model.address.GetAddressResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface IAddressDataSource {

    @POST("saveAddress")
    Observable<AddressResponse> saveAddress(@Body AddressRequest addressRequest);

    @GET("getAllAddress")
    Observable<GetAddressResponse> getAllAddress();

    @PUT("editAddress")
    Observable<AddressResponse> editAddress(@Body AddressRequest addressRequest);
}
