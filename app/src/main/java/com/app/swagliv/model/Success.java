package com.app.swagliv.model;

import com.app.swagliv.model.Result;

public class Success<Data> extends Result {

    private final Data data;

    public Success(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

}
