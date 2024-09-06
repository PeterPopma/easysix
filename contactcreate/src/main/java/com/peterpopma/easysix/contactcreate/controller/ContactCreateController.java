package com.peterpopma.easysix.contactcreate.controller;

import com.peterpopma.easysix.contactcreate.dto.ContactObject;
import com.peterpopma.easysix.contactcreate.service.ContactCreateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/contact")
@Slf4j
public class ContactCreateController {

    @Autowired
    ContactCreateService contactCreateService;

    @PostMapping("")
    public ResponseEntity<String> contactCreate(@RequestBody ContactObject contact )
    {
        long startTime = System.currentTimeMillis();
        contactCreateService.createContact(contact);
        long endTime = System.currentTimeMillis();
        log.info("contactCreate: " + contact.getId() + " - " + (endTime - startTime) + " ms");

        return new ResponseEntity("created contact " + contact.getId(), HttpStatus.OK);
    }

}
