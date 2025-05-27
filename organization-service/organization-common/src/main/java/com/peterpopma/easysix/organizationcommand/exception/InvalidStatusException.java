package com.peterpopma.easysix.organizationcommand.exception;

public class InvalidStatusException extends RuntimeException {
    public InvalidStatusException(String message, Throwable cause) {
        super(message, cause);
    }
}
