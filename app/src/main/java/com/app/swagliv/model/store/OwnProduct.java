package com.app.swagliv.model.store;

import java.io.Serializable;
import java.util.ArrayList;

public class OwnProduct implements Serializable {

    private String _id;
    private String customerId;
    private String category;
    private String subCategory;
    private String productName;
    private float coins;
    private String description;
    private String specification;
    ArrayList< String > colors = new ArrayList < String > ();
    ArrayList < String > productImages = new ArrayList < String > ();
    private boolean productStatus;
    private String createdAt;
    private String updatedAt;

    public OwnProduct(String _id, String customerId, String category, String subCategory, String productName, float coins, String description, String specification, ArrayList<String> colors, ArrayList<String> productImages, boolean productStatus, String createdAt, String updatedAt) {
        this._id = _id;
        this.customerId = customerId;
        this.category = category;
        this.subCategory = subCategory;
        this.productName = productName;
        this.coins = coins;
        this.description = description;
        this.specification = specification;
        this.colors = colors;
        this.productImages = productImages;
        this.productStatus = productStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getCoins() {
        return coins;
    }

    public void setCoins(float coins) {
        this.coins = coins;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public ArrayList<String> getProductImages() {
        return productImages;
    }

    public void setProductImages(ArrayList<String> productImages) {
        this.productImages = productImages;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
