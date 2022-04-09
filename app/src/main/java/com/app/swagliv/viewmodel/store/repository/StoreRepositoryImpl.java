package com.app.swagliv.viewmodel.store.repository;

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
import com.app.swagliv.viewmodel.store.datasource.IStoreDataSource;

import java.io.File;
import java.io.IOException;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class StoreRepositoryImpl implements IStoreRepository {

    private final IStoreDataSource iStoreDataSource;

    public StoreRepositoryImpl(IStoreDataSource iStoreDataSource) {
        this.iStoreDataSource = iStoreDataSource;
    }

    @Override
    public Observable<OwnProductResponse> getProductListing() {
        return iStoreDataSource.getProductListing();
    }

    @Override
    public Observable<CategoryResponse> getAllCategories() {
        return iStoreDataSource.getAllCategories();
    }

    @Override
    public FileResponse uploadProductImages(String image) throws Exception {
        File file =new File(image);
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        return iStoreDataSource.uploadProductImages(body).execute().body();
    }

    @Override
    public Observable<CreateProductResponse> createProducts(CreateProductRequest createProductRequest) {
        return iStoreDataSource.createProducts(createProductRequest);
    }

    @Override
    public Observable<OwnProductResponse> getAllProducts() {
        return iStoreDataSource.getAllProducts();
    }

    @Override
    public Observable<AddToCartResponse> addItemToCart(AddToCartRequest addToCartRequest) {
        return iStoreDataSource.addItemToCart(addToCartRequest);
    }

    @Override
    public Observable<AllCartProductResponse> getAllCartProducts() {
        return iStoreDataSource.getAllCartProducts();
    }

    @Override
    public Observable<RemoveCartResponse> removeProductFromCart(CartProduct cartProduct) {
        return iStoreDataSource.removeProductFromCart(cartProduct);
    }

    @Override
    public Observable<WalletBalanceResponse> getWalletBalance() {
        return iStoreDataSource.getWalletBalance();
    }

    @Override
    public Observable<CheckoutForMySelfResponse> checkOutForMyself(CheckoutForMySelfRequest checkoutForMySelfRequest) {
        return iStoreDataSource.checkOutForMyself(checkoutForMySelfRequest);
    }

    @Override
    public Observable<OrderResponse> getAllBookedOrders() {
        return iStoreDataSource.getAllBookedOrders();
    }

    /*@Override
    public Success getProductListing() throws Exception {
        return new Success(iStoreDataSource.getProductListing().execute().body());
    }*/
}
