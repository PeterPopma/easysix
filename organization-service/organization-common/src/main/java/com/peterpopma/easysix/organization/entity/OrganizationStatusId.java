package com.peterpopma.easysix.organization.entity;

import java.io.Serializable;
import java.util.UUID;

import com.peterpopma.easysix.organization.model.OrganizationStatusType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationStatusId implements Serializable {
    private UUID organization;
    private OrganizationStatusType status;
}
