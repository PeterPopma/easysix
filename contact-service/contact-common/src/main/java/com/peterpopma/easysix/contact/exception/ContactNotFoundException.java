package com.peterpopma.easysix.contactcommand.exception;

import java.util.UUID;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(UUID id) {
        super("Contact not found with id: " + id);
    }
}
