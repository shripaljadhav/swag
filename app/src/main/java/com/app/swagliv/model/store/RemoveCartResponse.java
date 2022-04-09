package com.app.swagliv.model.store;

public class RemoveCartResponse {

    private final String Message;

    public RemoveCartResponse(String Message) {
        this.Message = Message;
    }

    public String getMessage() {
        return Message;
    }
}
