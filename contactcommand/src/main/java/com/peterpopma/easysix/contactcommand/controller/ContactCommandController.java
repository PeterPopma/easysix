package com.peterpopma.easysix.contactcommand.controller;

import com.peterpopma.easysix.contactcommand.dto.ContactObject;
import com.peterpopma.easysix.contactcommand.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/contact")
@Slf4j
public class ContactCommandController {

    @Autowired
    ContactService contactService;

    @PostMapping("")
    public ResponseEntity<String> contactCreate(@RequestBody ContactObject contact )
    {
        contactService.createContact(contact);
        log.debug("contactCreate: " + contact.id());

        return new ResponseEntity("created contact " + contact.id(), HttpStatus.OK);
    }
    
    @PutMapping("")
    public ResponseEntity<String> contactUpdate(@RequestBody ContactObject contact )
    {
        contactService.updateContact(contact);
        log.debug("contactUpdate: " + contact.id());

        return new ResponseEntity("updated contact " + contact.id(), HttpStatus.OK);
    }
    
    @DeleteMapping("/{contactId}")
    public ResponseEntity<String> contactDelete(@PathVariable UUID contactId)
    {
        contactService.deleteContactById(contactId);
        log.debug("contactDelete: " + contactId);

        return new ResponseEntity("deleted contact " + contactId, HttpStatus.OK);
    }

}
