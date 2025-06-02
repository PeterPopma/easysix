package com.peterpopma.easysix.organization.model;

import com.peterpopma.easysix.organization.exception.InvalidStatusException;

public enum OrganizationRoleStatusType {
    ok,
    clientLinkProhibited,
    linked,
    serverLinkProhibited;

    public static OrganizationRoleStatusType fromValue(String value) {
        try {
            return OrganizationRoleStatusType.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidStatusException("Invalid status: " + value, e);
        }
    }
}