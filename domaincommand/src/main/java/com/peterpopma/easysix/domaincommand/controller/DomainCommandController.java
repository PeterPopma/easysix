package com.peterpopma.easysix.domaincommand.controller;

import com.peterpopma.easysix.domaincommand.dto.DomainObject;
import com.peterpopma.easysix.domaincommand.service.DomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/domain")
@Slf4j
public class DomainCommandController {

    @Autowired
    DomainService domainService;

    @PostMapping("")
    public ResponseEntity<String> domainCreate(@RequestBody DomainObject domain )
    {
        long startTime = System.currentTimeMillis();
        domainService.createDomain(domain);
        long endTime = System.currentTimeMillis();
        log.debug("domainCreate: " + domain.id() + " - " + (endTime - startTime) + " ms");

        return new ResponseEntity("created domain " + domain.id(), HttpStatus.OK);
    }
    
    @PutMapping("")
    public ResponseEntity<String> domainUpdate(@RequestBody DomainObject domain )
    {
        long startTime = System.currentTimeMillis();
        domainService.updateDomain(domain);
        long endTime = System.currentTimeMillis();
        log.info("domainUpdate: " + domain.id() + " - " + (endTime - startTime) + " ms");

        return new ResponseEntity("updated domain " + domain.id(), HttpStatus.OK);
    }
    
    @DeleteMapping("/{domainId}")
    public ResponseEntity<String> domainDelete(@PathVariable String domainId)
    {
        long startTime = System.currentTimeMillis();
        domainService.deleteDomainByName(domainId);
        long endTime = System.currentTimeMillis();
        log.info("domainDelete: " + domainId + " - " + (endTime - startTime) + " ms");

        return new ResponseEntity("deleted domain " + domainId, HttpStatus.OK);
    }

}
