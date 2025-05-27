package com.peterpopma.easysix.organizationcommand.entity;

import java.io.Serializable;
import java.util.UUID;

import com.peterpopma.easysix.organizationcommand.model.OrganizationStatusType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationStatusId implements Serializable {
    private UUID organization;
    private OrganizationStatusType status;
}
