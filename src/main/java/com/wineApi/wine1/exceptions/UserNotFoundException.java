package com.wineApi.wine1.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super(ValidationMessages.USER_NOT_FOUND);
    }
}
