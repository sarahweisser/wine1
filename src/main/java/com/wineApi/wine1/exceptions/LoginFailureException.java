package com.wineApi.wine1.exceptions;

public class LoginFailureException extends RuntimeException {
    public LoginFailureException() {
        super(ValidationMessages.INCORRECT_PASS);
    }
}
