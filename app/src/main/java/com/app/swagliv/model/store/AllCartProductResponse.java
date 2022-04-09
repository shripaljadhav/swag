package com.app.swagliv.model.store;

import java.util.ArrayList;

public class AllCartProductResponse {

    private ArrayList<CartProduct> Data;

    public AllCartProductResponse(ArrayList<CartProduct> data) {
        Data = data;
    }

    public ArrayList<CartProduct> getData() {
        return Data;
    }

    public void setData(ArrayList<CartProduct> data) {
        Data = data;
    }
}
