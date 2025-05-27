package com.peterpopma.easysix.domain.exception;

import java.util.UUID;

public class DomainNotFoundException extends RuntimeException {
    public DomainNotFoundException(UUID id) {
        super("Domain with ID " + id + " not found.");
    }
}

