package com.peterpopma.easysix.organization.entity;

import com.peterpopma.easysix.organization.model.OrganizationRoleStatusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationRoleStatusId implements Serializable {
    private UUID organizationRole;
    private OrganizationRoleStatusType status;
}
