package com.app.swagliv.view;

public class InSufficientWalletBalanceException extends Exception{

    public InSufficientWalletBalanceException(String message) {
        super(message);
    }
}
