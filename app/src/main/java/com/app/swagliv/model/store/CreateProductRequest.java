package com.app.swagliv.model.store;

import java.util.ArrayList;

public class CreateProductRequest {

    private String productName;
    private String description;
    private String specification;
    private String category;
    private String subCategory;
    private String coins;
    private ArrayList<String> colors = new ArrayList<String>();
    private ArrayList<String> productImages = new ArrayList <String> ();

    public CreateProductRequest(String productName, String description, String specification, String category, String subCategory, String coins, ArrayList<String> colors, ArrayList<String> productImages) {
        this.productName = productName;
        this.description = description;
        this.specification = specification;
        this.category = category;
        this.subCategory = subCategory;
        this.coins = coins;
        this.colors = colors;
        this.productImages = productImages;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getCoins() {
        return coins;
    }

    public void setCoins(String coins) {
        this.coins = coins;
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

}
