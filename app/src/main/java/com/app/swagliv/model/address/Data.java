package com.app.swagliv.model.address;

public class Data {

    private String _id;
    private String customerId;
    private AddressList AddressList;

    public Data(String _id, String customerId, com.app.swagliv.model.address.AddressList addressList) {
        this._id = _id;
        this.customerId = customerId;
        AddressList = addressList;
    }

    public String get_id() {
        return _id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public com.app.swagliv.model.address.AddressList getAddressList() {
        return AddressList;
    }
}
