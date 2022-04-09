package com.app.swagliv.model.store;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoryResponse implements Serializable {

    private float status;
    private String Message;
    ArrayList<Category> Data;

    public CategoryResponse(float status, String message, ArrayList<Category> data) {
        this.status = status;
        Message = message;
        Data = data;
    }

    public float getStatus() {
        return status;
    }

    public void setStatus(float status) {
        this.status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public ArrayList<Category> getData() {
        return Data;
    }

    public void setData(ArrayList<Category> data) {
        Data = data;
    }
}
