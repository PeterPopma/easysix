package com.peterpopma.easysix.contactquery.controller;

import com.peterpopma.easysix.contactquery.dto.ContactDto;
import com.peterpopma.easysix.contactquery.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/contact")
@Slf4j
public class ContactQueryController {

    @Autowired
    ContactService contactService;

    @GetMapping("/{contactId}")
    public ContactDto contactInfo(@PathVariable UUID contactId)
    {
        ContactDto contactObject = contactService.findContactById(contactId);
        log.debug("contactInfo: " + contactId);

        return contactObject;
    }

    @GetMapping("")
    public List<UUID> getAllContacts()
    {
        List<UUID> contactList = contactService.findAllContacts();
        log.debug("requested all contacts");

        return contactList;
    }
}
