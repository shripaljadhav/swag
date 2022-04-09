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

import io.reactivex.rxjava3.core.Observable;

public interface IStoreRepository {
    Observable<OwnProductResponse> getProductListing();

    Observable<CategoryResponse> getAllCategories();

    FileResponse uploadProductImages(String image) throws Exception;

    Observable<CreateProductResponse> createProducts(CreateProductRequest createProductRequest);

    Observable<OwnProductResponse> getAllProducts();

    Observable<AddToCartResponse> addItemToCart(AddToCartRequest addToCartRequest);

    Observable<AllCartProductResponse> getAllCartProducts();

    Observable<RemoveCartResponse> removeProductFromCart(CartProduct cartProduct);

    Observable<WalletBalanceResponse> getWalletBalance();

    Observable<CheckoutForMySelfResponse> checkOutForMyself(CheckoutForMySelfRequest checkoutForMySelfRequest);

    Observable<OrderResponse> getAllBookedOrders();
}
