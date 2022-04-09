package com.app.swagliv.model.store;

public class ProductData {

    private final String orderId;
    private final float coins;

    public ProductData(String orderId, float coins) {
        this.orderId = orderId;
        this.coins = coins;
    }

    public String getOrderId() {
        return orderId;
    }

    public float getCoins() {
        return coins;
    }
}
