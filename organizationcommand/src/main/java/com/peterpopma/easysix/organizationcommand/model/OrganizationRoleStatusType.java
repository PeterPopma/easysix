package com.peterpopma.easysix.organizationcommand.model;

import com.peterpopma.easysix.organizationcommand.exception.InvalidStatusException;

public enum OrganizationRoleStatusType {
    ok,
    clientLinkProhibited,
    linked,
    serverLinkProhibited;

    public static OrganizationRoleStatusType fromValue(String value) {
        try {
            return OrganizationRoleStatusType.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidStatusException("Invalid status: " + value);
        }
    }
}