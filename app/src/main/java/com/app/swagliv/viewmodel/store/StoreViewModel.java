package com.app.swagliv.viewmodel.store;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

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
import com.app.swagliv.model.store.AddToCartResponse;
import com.app.swagliv.model.store.AllCartProductResponse;
import com.app.swagliv.model.store.CartProduct;
import com.app.swagliv.model.store.Category;
import com.app.swagliv.model.store.CategoryResponse;
import com.app.swagliv.model.store.CheckoutForMySelfRequest;
import com.app.swagliv.model.store.CheckoutForMySelfResponse;
import com.app.swagliv.model.store.CreateProductRequest;
import com.app.swagliv.model.store.CreateProductResponse;
import com.app.swagliv.model.store.FileResponse;
import com.app.swagliv.model.store.Order;
import com.app.swagliv.model.store.OrderResponse;
import com.app.swagliv.model.store.OwnProduct;
import com.app.swagliv.model.store.OwnProductResponse;
import com.app.swagliv.model.store.AddToCartRequest;
import com.app.swagliv.model.store.ProductData;
import com.app.swagliv.model.store.RemoveCartResponse;
import com.app.swagliv.model.store.WalletBalanceResponse;
import com.app.swagliv.network.ApplicationRetrofitServices;
import com.app.swagliv.view.InSufficientWalletBalanceException;
import com.app.swagliv.viewmodel.store.datasource.IStoreDataSource;
import com.app.swagliv.viewmodel.store.repository.IStoreRepository;
import com.app.swagliv.viewmodel.store.repository.StoreRepositoryImpl;

import java.util.ArrayList;
import java.util.function.Function;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public final class StoreViewModel extends AndroidViewModel {

    private final IStoreRepository iStoreRepository;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private static StoreViewModel storeViewModel;
    private Application application;

    private StoreViewModel(@NonNull Application application, IStoreRepository iStoreRepository) {
        super(application);
        this.application = application;
        this.iStoreRepository = iStoreRepository;
    }

    public static StoreViewModel getInstance(Application application) {
        if (storeViewModel == null) {
            final IStoreDataSource iStoreDataSource = ApplicationRetrofitServices.getInstance().getStoreService();
            storeViewModel = new StoreViewModel(application, new StoreRepositoryImpl(iStoreDataSource));
        }
        return storeViewModel;
    }

    public LiveData<Result> getProductListing() {
        return new MutableLiveData<Result>() {
            {
                setValue(new Loading());
                iStoreRepository
                        .getProductListing()
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .subscribe(new Observer<OwnProductResponse>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                            }

                            @Override
                            public void onNext(@NonNull OwnProductResponse ownProductResponse) {
                                postValue(new Success<ArrayList<OwnProduct>>(ownProductResponse.getData()));
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                postValue(new Error(new Exception(application.getResources().getString(R.string.api_failure_error_msg))));
                            }

                            @Override
                            public void onComplete() {
                            }
                        });
            }
        };
    }

    public LiveData<Result> getAllCategories() {
        return new MutableLiveData<Result>() {
            {
                setValue(new Loading());
                iStoreRepository.getAllCategories()
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .subscribe(new Observer<CategoryResponse>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                            }

                            @Override
                            public void onNext(@NonNull CategoryResponse categoryResponse) {
                                postValue(new Success<ArrayList<Category>>(categoryResponse.getData()));
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                postValue(new Error(new Exception(application.getResources().getString(R.string.api_failure_error_msg))));
                            }

                            @Override
                            public void onComplete() {
                            }
                        });
            }
        };
    }

    public LiveData<Result> proceedToImageUpload(String category, String subCategory, String productName, String coin, String description, String specification, ArrayList<String> colors) {
        return new MutableLiveData<Result>() {
            {
                try {
                    if (category == null || category.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_select_category));
                    }
                    if (subCategory == null || subCategory.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_select_sub_category));
                    }
                    if (productName == null || productName.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_valid_productName));
                    }
                    if (coin == null || coin.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_valid_coin));
                    }
                    if (description == null || description.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_valid_description));
                    }
                    if (specification == null || specification.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_enter_valid_specification));
                    }
                    if (colors == null || colors.isEmpty()) {
                        throw new Exception(getApplication().getResources().getString(R.string.error_add_valid_colors));
                    }
                    setValue(new Success<>(null));
                } catch (Exception e) {
                    setValue(new Error(e));
                }
            }
        };
    }

    public String getSubCategory(ArrayList<Category> items, int subCategorySelectedIndex) {
        if (subCategorySelectedIndex >= 0) {
            return items.get(subCategorySelectedIndex).getLabel();
        }
        return null;
    }

    public String getCategory(ArrayList<Category> items, int categorySelectedIndex) {
        if (categorySelectedIndex >= 0) {
            return items.get(categorySelectedIndex).getLabel();
        }
        return null;
    }

    public LiveData<Result> createProducts(ArrayList<String> images, String description, String specification, String coins, String productName, String category, String subCategory, ArrayList<String> colors) {
        return new MutableLiveData<Result>() {
            {
                try {
                    setValue(new Loading());
                    disposables.add(Observable.defer(new Supplier<ObservableSource<ArrayList<String>>>() {
                        @Override
                        public ObservableSource<ArrayList<String>> get() throws Throwable {
                            final ArrayList<String> productImages = new ArrayList<>();
                            for (String image : images) {
                                try {
                                    FileResponse fileResponse = iStoreRepository.uploadProductImages(image);
                                    productImages.add(fileResponse.getFile_URL());
                                } catch (Exception exception) {
                                    return Observable.error(exception);
                                }
                            }
                            return Observable.just(productImages);
                        }
                    }).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribeWith(new DisposableObserver<ArrayList<String>>() {
                        @Override
                        public void onNext(@io.reactivex.rxjava3.annotations.NonNull ArrayList<String> productImages) {
                            iStoreRepository.createProducts(new CreateProductRequest(
                                    productName,
                                    description,
                                    specification,
                                    category,
                                    subCategory,
                                    coins,
                                    colors,
                                    productImages
                            )).subscribeOn(Schedulers.io())
                                    .observeOn(Schedulers.io())
                                    .subscribe(new Observer<CreateProductResponse>() {
                                        @Override
                                        public void onSubscribe(@NonNull Disposable d) {
                                        }

                                        @Override
                                        public void onNext(@NonNull CreateProductResponse createProductResponse) {
                                            postValue(new Success<String>(createProductResponse.getMessage()));
                                            //postValue(new Success<ArrayList<Category>>(categoryResponse.getData()));
                                        }

                                        @Override
                                        public void onError(@NonNull Throwable e) {
                                            postValue(new Error(new Exception(application.getResources().getString(R.string.api_failure_error_msg))));
                                        }

                                        @Override
                                        public void onComplete() {
                                        }
                                    });
                        }

                        @Override
                        public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                            postValue(new Error(new Exception(application.getResources().getString(R.string.api_failure_error_msg))));
                        }

                        @Override
                        public void onComplete() {
                        }
                    }));
                } catch (Exception exception) {
                    setValue(new Error(exception));
                }
            }
        };
    }

    public LiveData<Result> getAllProducts() {
        return new MutableLiveData<Result>() {
            {
                setValue(new Loading());
                iStoreRepository
                        .getAllProducts()
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .subscribe(new Observer<OwnProductResponse>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                            }

                            @Override
                            public void onNext(@NonNull OwnProductResponse ownProductResponse) {
                                postValue(new Success<ArrayList<OwnProduct>>(ownProductResponse.getData()));
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                postValue(new Error(new Exception(application.getResources().getString(R.string.api_failure_error_msg))));
                            }

                            @Override
                            public void onComplete() {
                            }
                        });
            }
        };
    }

    public LiveData<Result> searchProducts(String query, ArrayList<OwnProduct> products) {
        return new MutableLiveData<Result>() {
            {
                disposables.add(Observable.defer((Supplier<ObservableSource<ArrayList<OwnProduct>>>) () -> {
                    final ArrayList<OwnProduct> searchProducts = new ArrayList<OwnProduct>();
                    for (OwnProduct ownProduct : products) {
                        if (ownProduct.getProductName().trim().toLowerCase().startsWith(query)) {
                            searchProducts.add(ownProduct);
                        }
                    }
                    if (searchProducts.isEmpty()) {
                        return Observable.error(new Exception());
                    }
                    return Observable.just(searchProducts);
                }).subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .subscribeWith(new DisposableObserver<ArrayList<OwnProduct>>() {
                            @Override
                            public void onComplete() {
                            }

                            @Override
                            public void onNext(@io.reactivex.rxjava3.annotations.NonNull ArrayList<OwnProduct> ownProducts) {
                                postValue(new Success<ArrayList<OwnProduct>>(ownProducts));
                            }

                            @Override
                            public void onError(Throwable e) {}
                        }));
            }
        };
    }

    public LiveData<Result> searchProductsByFilter(Category selectedCategory, Category selectedSubCategory, Float coins, ArrayList<OwnProduct> products) {
        return new MutableLiveData<Result>() {
            {
                disposables.add(Observable.defer((Supplier<ObservableSource<ArrayList<OwnProduct>>>) () -> {
                    final ArrayList<OwnProduct> searchProducts = new ArrayList<OwnProduct>();
                    for (OwnProduct ownProduct : products) {
                        if (ownProduct.getCategory().trim().toLowerCase().equals(selectedCategory.getLabel().trim().toLowerCase())
                                && ownProduct.getSubCategory().trim().toLowerCase().equals(selectedSubCategory.getLabel().trim().toLowerCase())
                                && ownProduct.getCoins() == coins.floatValue()) {
                            searchProducts.add(ownProduct);
                        }
                    }
                    if (searchProducts.isEmpty()) {
                        return Observable.error(new Exception());
                    }
                    return Observable.just(searchProducts);
                }).subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .subscribeWith(new DisposableObserver<ArrayList<OwnProduct>>() {
                            @Override
                            public void onComplete() {
                            }

                            @Override
                            public void onNext(@io.reactivex.rxjava3.annotations.NonNull ArrayList<OwnProduct> ownProducts) {
                                postValue(new Success<ArrayList<OwnProduct>>(ownProducts));
                            }

                            @Override
                            public void onError(Throwable e) {
                            }
                        }));
            }
        };
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }

    public LiveData<Result> addItemToCart(String id) {
        return new MutableLiveData<Result>() {
            {
                setValue(new Loading());
                iStoreRepository
                        .addItemToCart(new AddToCartRequest(id))
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .subscribe(new Observer<AddToCartResponse>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                            }

                            @Override
                            public void onNext(@NonNull AddToCartResponse ownProductResponse) {
                                postValue(new Success<String>(ownProductResponse.getMessage()));
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                postValue(new Error(new Exception(application.getResources().getString(R.string.api_failure_error_msg))));
                            }

                            @Override
                            public void onComplete() {
                            }
                        });
            }
        };
    }

    public LiveData<Result> getAllCartProducts() {
        return new MutableLiveData<Result>() {
            {
                setValue(new Loading());
                iStoreRepository
                        .getAllCartProducts()
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .subscribe(new Observer<AllCartProductResponse>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                            }

                            @Override
                            public void onNext(@NonNull AllCartProductResponse ownProductResponse) {
                                postValue(new Success<ArrayList<CartProduct>>(ownProductResponse.getData()));
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                postValue(new Error(new Exception(application.getResources().getString(R.string.api_failure_error_msg))));
                            }

                            @Override
                            public void onComplete() {
                            }
                        });
            }
        };
    }

    public LiveData<Result> removeProductFromCart(CartProduct cartProduct) {
        return new MutableLiveData<Result>() {
            {
                setValue(new Loading());
                iStoreRepository
                        .removeProductFromCart(cartProduct)
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .subscribe(new Observer<RemoveCartResponse>() {
                            @Override
                            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {}
                            @Override
                            public void onNext(@io.reactivex.rxjava3.annotations.NonNull RemoveCartResponse removeCartResponse) {
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        getAllCartProducts().observeForever(new androidx.lifecycle.Observer<Result>() {
                                            @Override
                                            public void onChanged(Result result) {
                                                if (result instanceof Success) {
                                                    postValue(result);
                                                    removeObserver(this);
                                                }
                                                if (result instanceof Error) {
                                                    postValue(result);
                                                    removeObserver(this);
                                                }
                                            }
                                        });
                                    }
                                });
                            }
                            @Override
                            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                                postValue(new Error(new Exception(application.getResources().getString(R.string.api_failure_error_msg))));
                            }
                            @Override
                            public void onComplete() {}
                        });
            }
        };
    }

    public LiveData<Result> isCoinAvailableToPurchaseProduct(ArrayList<CartProduct> cartProducts, AddressList addressList) {
        return new MutableLiveData<Result>(){
            {
                iStoreRepository
                        .getWalletBalance()
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .subscribe(new Observer<WalletBalanceResponse>() {
                            @Override
                            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@io.reactivex.rxjava3.annotations.NonNull WalletBalanceResponse walletBalanceResponse) {
                                float coins = 0;
                                for (CartProduct cartProduct: cartProducts) {
                                    coins = coins + cartProduct.getCoins();
                                }
                                if(Float.parseFloat(walletBalanceResponse.getData().getWalletBalance())>coins){
                                    ArrayList<ProductData> productDataArrayList = new ArrayList<>();
                                    for (CartProduct cartProduct : cartProducts){
                                        final ProductData productData = new ProductData(cartProduct.getOrderId(),cartProduct.getCoins());
                                        productDataArrayList.add(productData);
                                    }
                                    float finalCoins = coins;
                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                        @Override
                                        public void run() {
                                            checkOutForMyself(new CheckoutForMySelfRequest(
                                                    finalCoins,
                                                    productDataArrayList,
                                                    addressList
                                            )).observeForever(result -> postValue(result));
                                        }
                                    });
                                } else {
                                    postValue(new Error(new InSufficientWalletBalanceException(
                                            String.format(application.getResources().getString(R.string.wallet_balance), walletBalanceResponse.getData().getWalletBalance())
                                    )));
                                }
                            }

                            @Override
                            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                                postValue(new Error(new Exception(application.getResources().getString(R.string.api_failure_error_msg))));
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        };
    }


    public LiveData<Result> checkOutForMyself(final CheckoutForMySelfRequest checkoutForMySelfRequest) {
        return new MutableLiveData<Result>(){
            {
                iStoreRepository
                        .checkOutForMyself(checkoutForMySelfRequest)
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .subscribe(new Observer<CheckoutForMySelfResponse>() {
                            @Override
                            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@io.reactivex.rxjava3.annotations.NonNull CheckoutForMySelfResponse checkoutForMySelfResponse) {
                                postValue(new Success<String>(checkoutForMySelfResponse.getMessage()));
                            }

                            @Override
                            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                                postValue(new Error(new Exception(application.getResources().getString(R.string.api_failure_error_msg))));
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        };
    }

    public LiveData<Result> getAllBookedOrders() {
        return new MutableLiveData<Result>(){
            {
                iStoreRepository
                        .getAllBookedOrders()
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .subscribe(new Observer<OrderResponse>(){

                            @Override
                            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@io.reactivex.rxjava3.annotations.NonNull OrderResponse orderResponse) {
                                postValue(new Success<ArrayList<Order>>(orderResponse.getData()));
                            }

                            @Override
                            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                                postValue(new Error(new Exception(application.getResources().getString(R.string.api_failure_error_msg))));
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        };
    }

    public LiveData<Result> isCartNotEmpty(ArrayList<CartProduct> cartProducts) {
        return new MutableLiveData<Result>(){
            {
                if(cartProducts==null || cartProducts.isEmpty()){
                    postValue(new Error(new Exception()));
                }
                else if (!cartProducts.isEmpty()){
                    postValue(new Success<Boolean>(true));
                }
            }
        };
    }
}
