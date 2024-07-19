package com.nzis.ignatovsoft.exceptions;

public class NHISErrorException extends Exception {
    private String errorCode;

    public NHISErrorException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public NHISErrorException(String message) {
        super(message);
    }

    public String getErrorCode() {
        return errorCode;
    }
}
