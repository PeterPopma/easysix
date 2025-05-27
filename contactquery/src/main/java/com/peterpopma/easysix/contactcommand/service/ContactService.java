package com.peterpopma.easysix.contactcommand.service;

import com.peterpopma.easysix.contactcommand.dto.ContactDto;

import java.util.UUID;

public interface ContactService {
    ContactDto create(ContactDto contactDto);
    ContactDto update(UUID id, ContactDto contactDto);
    void delete(UUID id);
}

