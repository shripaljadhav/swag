package com.app.swagliv.model.store;

import java.util.ArrayList;

public class OwnProductResponse {

    private ArrayList<OwnProduct> Data;

    public OwnProductResponse(ArrayList<OwnProduct> data) {
        Data = data;
    }

    public ArrayList<OwnProduct> getData() {
        return Data;
    }

    public void setData(ArrayList<OwnProduct> data) {
        Data = data;
    }
}
