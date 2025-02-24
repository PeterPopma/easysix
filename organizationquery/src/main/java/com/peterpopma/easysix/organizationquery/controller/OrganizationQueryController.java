package com.peterpopma.easysix.organizationquery.controller;

import com.peterpopma.easysix.organizationquery.dto.OrganizationObject;
import com.peterpopma.easysix.organizationquery.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/organization")
@Slf4j
public class OrganizationQueryController {

    @Autowired
    OrganizationService organizationService;

    @GetMapping("/{organizationId}")
    public OrganizationObject organizationInfo(@PathVariable UUID organizationId)
    {
        OrganizationObject organizationObject = organizationService.findOrganizationById(organizationId);
        log.debug("organizationInfo: " + organizationId);

        return organizationObject;
    }

    @GetMapping("")
    public List<UUID> getAllOrganizations()
    {
        List<UUID> organizationList = organizationService.findAllOrganizations();
        log.debug("requested all organizations");

        return organizationList;
    }
}
