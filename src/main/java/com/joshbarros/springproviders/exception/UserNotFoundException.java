package com.joshbarros.springproviders.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String email) {
        super("User with given email already exists: " + email);
    }
}
