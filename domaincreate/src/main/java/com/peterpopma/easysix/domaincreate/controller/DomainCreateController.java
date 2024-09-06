package com.peterpopma.easysix.domaincreate.controller;

import com.peterpopma.easysix.domaincreate.dto.request.DomainObject;
import com.peterpopma.easysix.domaincreate.service.DomainCreateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/domain")
@Slf4j
public class DomainCreateController {

    @Autowired
    DomainCreateService domainCreateService;

    @PostMapping("")
    public ResponseEntity<String> domainCreate(@RequestBody DomainObject domain )
    {
        long startTime = System.currentTimeMillis();
        domainCreateService.createDomain(domain);
        long endTime = System.currentTimeMillis();
        log.info("domainCreate: " + domain.getId() + " - " + (endTime - startTime) + " ms");

        return new ResponseEntity("created domain " + domain.getId(), HttpStatus.OK);
    }

}
