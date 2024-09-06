package com.peterpopma.easysix.contactupdate.controller;

import com.peterpopma.easysix.contactupdate.dto.ContactObject;
import com.peterpopma.easysix.contactupdate.service.ContactUpdateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/contact")
@Slf4j
public class ContactUpdateController {

    @Autowired
    ContactUpdateService contactUpdateService;

    @PutMapping("")
    public ResponseEntity<String> contactUpdate(@RequestBody ContactObject contact )
    {
        long startTime = System.currentTimeMillis();
        contactUpdateService.updateContact(contact);
        long endTime = System.currentTimeMillis();
        log.info("contactUpdate: " + contact.getId() + " - " + (endTime - startTime) + " ms");

        return new ResponseEntity("updated contact " + contact.getId(), HttpStatus.OK);
    }

}
