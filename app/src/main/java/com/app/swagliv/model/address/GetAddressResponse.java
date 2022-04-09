package com.app.swagliv.model.address;

public class GetAddressResponse {

    private float status;
    private String Message;
    private GetAddressData Data;

    public GetAddressResponse(float status, String message, GetAddressData data) {
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

    public GetAddressData getData() {
        return Data;
    }

    public void setData(GetAddressData data) {
        Data = data;
    }
}
