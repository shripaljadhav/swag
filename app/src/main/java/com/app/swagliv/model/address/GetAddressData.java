package com.app.swagliv.model.address;

import java.util.ArrayList;

public class GetAddressData {

    private String _id;
    private String customerId;
    private ArrayList<AddressList> addressList;

    public GetAddressData(String _id, String customerId, ArrayList<AddressList> addressList) {
        this._id = _id;
        this.customerId = customerId;
        this.addressList = addressList;
    }

    public String get_id() {
        return _id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public ArrayList<AddressList> getAddressList() {
        return addressList;
    }
}
