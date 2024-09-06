package com.peterpopma.easysix.contactinfo.controller;

import com.peterpopma.easysix.contactinfo.dto.ContactObject;
import com.peterpopma.easysix.contactinfo.service.ContactInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/contact")
@Slf4j
public class ContactInfoController {

    @Autowired
    ContactInfoService contactInfoService;

    @GetMapping("/{contactId}")
    public ContactObject contactInfo(@PathVariable String contactId)
    {
        long startTime = System.currentTimeMillis();
        ContactObject contactInfo = contactInfoService.findContactByName(contactId);
        long endTime = System.currentTimeMillis();
        log.info("contactInfo: " + contactId + " - " + (endTime - startTime) + " ms");

        return contactInfo;
    }
}
