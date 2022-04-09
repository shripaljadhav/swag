package com.app.swagliv.model.store;

import com.app.swagliv.model.address.AddressList;

import java.util.ArrayList;

public class CheckoutForMySelfRequest {

    private final float totalCoins;
    private final ArrayList<ProductData> productsData;
    private final AddressList deliveryAddress;

    public CheckoutForMySelfRequest(float totalCoins, ArrayList<ProductData> productsData, AddressList deliveryAddress) {
        this.totalCoins = totalCoins;
        this.productsData = productsData;
        this.deliveryAddress = deliveryAddress;
    }

    public float getTotalCoins() {
        return totalCoins;
    }

    public ArrayList<ProductData> getProductsData() {
        return productsData;
    }

    public AddressList getDeliveryAddress() {
        return deliveryAddress;
    }
}
