package com.peterpopma.easysix.domaindelete.controller;

import com.peterpopma.easysix.domaindelete.service.DomainDeleteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/domain")
@Slf4j
public class DomainDeleteController {

    @Autowired
    DomainDeleteService domainDeleteService;

    @DeleteMapping("/{domainId}")
    public ResponseEntity<String> domainDelete(@PathVariable String domainId)
    {
        long startTime = System.currentTimeMillis();
        domainDeleteService.deleteDomainByName(domainId);
        long endTime = System.currentTimeMillis();
        log.info("domainDelete: " + domainId + " - " + (endTime - startTime) + " ms");

        return new ResponseEntity("deleted domain " + domainId, HttpStatus.OK);
    }
}
