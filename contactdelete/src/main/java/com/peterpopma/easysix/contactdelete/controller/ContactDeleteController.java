package com.peterpopma.easysix.contactdelete.controller;

import com.peterpopma.easysix.contactdelete.service.ContactDeleteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/contact")
@Slf4j
public class ContactDeleteController {

    @Autowired
    ContactDeleteService contactDeleteService;

    @DeleteMapping("/{contactId}")
    public ResponseEntity<String> contactDelete(@PathVariable String contactId)
    {
        long startTime = System.currentTimeMillis();
        contactDeleteService.deleteContactByName(contactId);
        long endTime = System.currentTimeMillis();
        log.info("contactDelete: " + contactId + " - " + (endTime - startTime) + " ms");

        return new ResponseEntity("deleted contact " + contactId, HttpStatus.OK);
    }
}
