package com.peterpopma.easysix.organizationcommand.controller;

import com.peterpopma.easysix.organizationcommand.dto.OrganizationObject;
import com.peterpopma.easysix.organizationcommand.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/organization")
@Slf4j
public class OrganizationCommandController {

    @Autowired
    OrganizationService organizationService;

    @PostMapping("")
    public ResponseEntity<String> organizationCreate(@RequestBody OrganizationObject organization )
    {
        organizationService.createOrganization(organization);
        log.debug("organizationCreate: " + organization.id());

        return new ResponseEntity("created organization " + organization.id(), HttpStatus.OK);
    }
    
    @PutMapping("")
    public ResponseEntity<String> organizationUpdate(@RequestBody OrganizationObject organization )
    {
        organizationService.updateOrganization(organization);
        log.debug("organizationUpdate: " + organization.id());

        return new ResponseEntity("updated organization " + organization.id(), HttpStatus.OK);
    }
    
    @DeleteMapping("/{organizationId}")
    public ResponseEntity<String> organizationDelete(@PathVariable UUID organizationId)
    {
        organizationService.deleteOrganizationById(organizationId);
        log.debug("organizationDelete: " + organizationId);

        return new ResponseEntity("deleted organization " + organizationId, HttpStatus.OK);
    }

}
