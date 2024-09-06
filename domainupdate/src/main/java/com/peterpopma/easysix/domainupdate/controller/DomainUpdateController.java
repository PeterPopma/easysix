package com.peterpopma.easysix.domainupdate.controller;

import com.peterpopma.easysix.domainupdate.dto.DomainObject;
import com.peterpopma.easysix.domainupdate.service.DomainUpdateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/domain")
@Slf4j
public class DomainUpdateController {

    @Autowired
    DomainUpdateService domainUpdateService;

    @PutMapping("")
    public ResponseEntity<String> domainUpdate(@RequestBody DomainObject domain )
    {
        long startTime = System.currentTimeMillis();
        domainUpdateService.updateDomain(domain);
        long endTime = System.currentTimeMillis();
        log.info("domainUpdate: " + domain.getId() + " - " + (endTime - startTime) + " ms");

        return new ResponseEntity("updated domain " + domain.getId(), HttpStatus.OK);
    }

}
