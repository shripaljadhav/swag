package com.app.swagliv.viewmodel.store.datasource;

import com.app.swagliv.model.store.AddToCartRequest;
import com.app.swagliv.model.store.AddToCartResponse;
import com.app.swagliv.model.store.AllCartProductResponse;
import com.app.swagliv.model.store.CartProduct;
import com.app.swagliv.model.store.CategoryResponse;
import com.app.swagliv.model.store.CheckoutForMySelfRequest;
import com.app.swagliv.model.store.CheckoutForMySelfResponse;
import com.app.swagliv.model.store.CreateProductRequest;
import com.app.swagliv.model.store.CreateProductResponse;
import com.app.swagliv.model.store.FileResponse;
import com.app.swagliv.model.store.OrderResponse;
import com.app.swagliv.model.store.OwnProductResponse;
import com.app.swagliv.model.store.RemoveCartResponse;
import com.app.swagliv.model.store.WalletBalanceResponse;

import java.io.File;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface IStoreDataSource {

    @GET("getOwnProductsList")
    Observable<OwnProductResponse> getProductListing();

    @GET("getAllCategories")
    Observable<CategoryResponse> getAllCategories();

    @Multipart
    @POST("uploadProductImages")
    Call<FileResponse> uploadProductImages(@Part MultipartBody.Part part);

    @POST("createProducts")
    Observable<CreateProductResponse> createProducts(@Body CreateProductRequest createProductRequest);

    @GET("getAllProducts")
    Observable<OwnProductResponse> getAllProducts();

    @POST("addItemToCart")
    Observable<AddToCartResponse> addItemToCart(@Body AddToCartRequest addToCartRequest);

    @GET("getAllCartProducts")
    Observable<AllCartProductResponse> getAllCartProducts();

    @POST("removeProductFromCart")
    Observable<RemoveCartResponse> removeProductFromCart(@Body CartProduct cartProduct);

    @GET("getWalletBalance")
    Observable<WalletBalanceResponse> getWalletBalance();

    @POST("checkOutForMyself")
    Observable<CheckoutForMySelfResponse> checkOutForMyself(@Body CheckoutForMySelfRequest checkoutForMySelfRequest);

    @GET("getAllBookedOrders")
    Observable<OrderResponse> getAllBookedOrders();
}
