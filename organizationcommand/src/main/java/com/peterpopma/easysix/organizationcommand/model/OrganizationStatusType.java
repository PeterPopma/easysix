package com.peterpopma.easysix.organizationcommand.model;

import com.peterpopma.easysix.organizationcommand.entity.OrganizationStatus;
import com.peterpopma.easysix.organizationcommand.exception.InvalidStatusException;

public enum OrganizationStatusType  {
    clientDeleteProhibited,
    clientTransferProhibited,
    clientUpdateProhibited,
    linked,
    ok,
    pendingCreate,
    pendingDelete,
    pendingTransfer,
    pendingUpdate,
    serverDeleteProhibited,
    serverTransferProhibited,
    serverUpdateProhibited;

    public static OrganizationStatusType fromValue(String value) {
        try {
            return OrganizationStatusType.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidStatusException("Invalid status: " + value);
        }
    }
}