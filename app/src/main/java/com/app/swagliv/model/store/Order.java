package com.app.swagliv.model.store;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {

    private String _id;
    private String productId;
    private String customerId;
    private String orderId;
    private String orderStatus;
    private float coins;
    private String bookedAt;
    private ArrayList< String > productImages;
    private String productName;

    public Order(String _id, String productId, String customerId, String orderId, String orderStatus, float coins, String bookedAt, ArrayList<String> productImages, String productName) {
        this._id = _id;
        this.productId = productId;
        this.customerId = customerId;
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.coins = coins;
        this.bookedAt = bookedAt;
        this.productImages = productImages;
        this.productName = productName;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public float getCoins() {
        return coins;
    }

    public void setCoins(float coins) {
        this.coins = coins;
    }

    public String getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(String bookedAt) {
        this.bookedAt = bookedAt;
    }

    public ArrayList<String> getProductImages() {
        return productImages;
    }

    public void setProductImages(ArrayList<String> productImages) {
        this.productImages = productImages;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
