package com.app.swagliv.model.store;

public class AddToCartResponse {

    private String Message;

    public AddToCartResponse(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
