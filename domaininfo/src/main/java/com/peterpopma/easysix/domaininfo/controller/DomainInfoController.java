package com.peterpopma.easysix.domaininfo.controller;

import com.peterpopma.easysix.domaininfo.dto.DomainObject;
import com.peterpopma.easysix.domaininfo.service.DomainInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/domain")
@Slf4j
public class DomainInfoController {

    @Autowired
    DomainInfoService domainInfoService;

    @GetMapping("/{domainId}")
    public DomainObject domainInfo(@PathVariable String domainId)
    {
        long startTime = System.currentTimeMillis();
        DomainObject domainObject = domainInfoService.findDomainByName(domainId);
        long endTime = System.currentTimeMillis();
        log.info("domainInfo: " + domainId + " - " + (endTime - startTime) + " ms");

        return domainObject;
    }
}
