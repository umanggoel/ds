package com.commons.exceptions;

public class InvalidInputExpception extends Exception {

    private final String errorMessage;

    public InvalidInputExpception(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }
}
