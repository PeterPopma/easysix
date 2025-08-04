package com.peterpopma.easysix.organization.exception;

public class InvalidStatusException extends RuntimeException {
    public InvalidStatusException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidStatusException(String message) {
        super(message);
    }
}
