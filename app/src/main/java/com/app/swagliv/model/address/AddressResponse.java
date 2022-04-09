package com.app.swagliv.model.address;

public class AddressResponse {

    private float status;
    private String Message;
    private Data Data;

    public AddressResponse(float status, String message, com.app.swagliv.model.address.Data data) {
        this.status = status;
        Message = message;
        Data = data;
    }

    public float getStatus() {
        return status;
    }

    public String getMessage() {
        return Message;
    }

    public com.app.swagliv.model.address.Data getData() {
        return Data;
    }
}
