package com.app.swagliv.model.store;

public class AddToCartRequest {

    private final String productId;

    public AddToCartRequest(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
