package com.communities.app.exceptions;

public class ArgumentErrorException extends RuntimeException {
    public ArgumentErrorException(String message) {
        super(message);
    }
}
