package com.app.swagliv.model.store;

public class CheckoutForMySelfResponse {

    private String Message;

    public CheckoutForMySelfResponse(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
