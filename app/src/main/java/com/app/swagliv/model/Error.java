package com.app.swagliv.model;

public class Error extends Result{

    private final Exception exception;

    public Error(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }
}
