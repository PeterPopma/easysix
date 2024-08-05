package com.peterpopma.easysix.domaininfo.controller;

import com.peterpopma.easysix.domaininfo.service.DomainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/domain")
public class DomainInfoController {

    @Autowired
    DomainInfoService domainInfoService;

    @GetMapping("/{domainId}")
    public String domainInfo(@PathVariable String domainId)
    {
        return domainInfoService.findDomainByName(domainId);
    }
}
