package com.app.swagliv.model.store;

import java.util.ArrayList;

public class OrderResponse {

    private ArrayList<Order> Data;

    public OrderResponse(ArrayList<Order> Data) {
        this.Data = Data;
    }

    public ArrayList<Order> getData() {
        return Data;
    }

    public void setData(ArrayList<Order> data) {
        Data = data;
    }
}
