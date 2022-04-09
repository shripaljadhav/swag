package com.app.swagliv.model.store;

import java.io.Serializable;

public class WalletBalanceResponse implements Serializable {

    private WalletData Data;

    public WalletBalanceResponse(WalletData data) {
        Data = data;
    }

    public WalletData getData() {
        return Data;
    }

    public void setData(WalletData data) {
        Data = data;
    }
}
