package com.app.swagliv.model.address;

import java.io.Serializable;
import java.util.Objects;

public class AddressList implements Serializable {

    private String name;
    private String mobileNumber;
    private String alternateMobileNumber;
    private String doorNumberAndBuildingName;
    private String streetName;
    private String city;
    private String pincode;
    private String state;
    private String landmark;
    private String addressId;

    public AddressList(String name, String mobileNumber, String alternateMobileNumber, String doorNumberAndBuildingName, String streetName, String city, String pincode, String state, String landmark, String addressId) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.alternateMobileNumber = alternateMobileNumber;
        this.doorNumberAndBuildingName = doorNumberAndBuildingName;
        this.streetName = streetName;
        this.city = city;
        this.pincode = pincode;
        this.state = state;
        this.landmark = landmark;
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAlternateMobileNumber() {
        return alternateMobileNumber;
    }

    public void setAlternateMobileNumber(String alternateMobileNumber) {
        this.alternateMobileNumber = alternateMobileNumber;
    }

    public String getDoorNumberAndBuildingName() {
        return doorNumberAndBuildingName;
    }

    public void setDoorNumberAndBuildingName(String doorNumberAndBuildingName) {
        this.doorNumberAndBuildingName = doorNumberAndBuildingName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "AddressList{" +
                "name='" + name + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", alternateMobileNumber='" + alternateMobileNumber + '\'' +
                ", doorNumberAndBuildingName='" + doorNumberAndBuildingName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", pincode='" + pincode + '\'' +
                ", state='" + state + '\'' +
                ", landmark='" + landmark + '\'' +
                ", addressId='" + addressId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressList that = (AddressList) o;
        return name.equals(that.name) && mobileNumber.equals(that.mobileNumber) && alternateMobileNumber.equals(that.alternateMobileNumber) && doorNumberAndBuildingName.equals(that.doorNumberAndBuildingName) && streetName.equals(that.streetName) && city.equals(that.city) && pincode.equals(that.pincode) && state.equals(that.state) && addressId.equals(that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mobileNumber, alternateMobileNumber, doorNumberAndBuildingName, streetName, city, pincode, state, landmark, addressId);
    }
}
