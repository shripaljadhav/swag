package com.app.swagliv.model.store;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class CartProduct implements Serializable {

    private String _id;
    private String productId;
    private String createdAt;
    private String productName;
    ArrayList< String > productImages;
    private float coins;
    private boolean productStatus;
    private String orderId;

    public CartProduct(String _id, String productId, String createdAt, String productName, ArrayList<String> productImages, float coins, boolean productStatus, String orderId) {
        this._id = _id;
        this.productId = productId;
        this.createdAt = createdAt;
        this.productName = productName;
        this.productImages = productImages;
        this.coins = coins;
        this.productStatus = productStatus;
        this.orderId = orderId;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ArrayList<String> getProductImages() {
        return productImages;
    }

    public void setProductImages(ArrayList<String> productImages) {
        this.productImages = productImages;
    }

    public float getCoins() {
        return coins;
    }

    public void setCoins(float coins) {
        this.coins = coins;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartProduct that = (CartProduct) o;
        return Float.compare(that.coins, coins) == 0 && productStatus == that.productStatus && _id.equals(that._id) && productId.equals(that.productId) && createdAt.equals(that.createdAt) && productName.equals(that.productName) && productImages.equals(that.productImages) && orderId.equals(that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, productId, createdAt, productName, productImages, coins, productStatus, orderId);
    }
}
