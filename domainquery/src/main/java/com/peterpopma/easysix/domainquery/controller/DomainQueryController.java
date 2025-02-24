package com.peterpopma.easysix.domainquery.controller;

import com.peterpopma.easysix.domainquery.dto.DomainObject;
import com.peterpopma.easysix.domainquery.service.DomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/domain")
@Slf4j
public class DomainQueryController {

    @Autowired
    DomainService domainService;

    @GetMapping("/{domainId}")
    public DomainObject domainInfo(@PathVariable String domainId)
    {
        long startTime = System.currentTimeMillis();
        DomainObject domainObject = domainService.findDomainByName(domainId);
        long endTime = System.currentTimeMillis();
        log.info("domainInfo: " + domainId + " - " + (endTime - startTime) + " ms");

        return domainObject;
    }
}
