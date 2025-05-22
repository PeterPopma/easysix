package com.peterpopma.easysix.organizationcommand.entity;

import com.peterpopma.easysix.organizationcommand.model.OrganizationRoleStatusType;
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
