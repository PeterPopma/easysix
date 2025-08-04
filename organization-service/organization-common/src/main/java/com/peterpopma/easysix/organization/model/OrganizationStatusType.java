package com.peterpopma.easysix.organization.model;

import com.peterpopma.easysix.organization.exception.InvalidStatusException;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrganizationStatusType {
    CLIENT_DELETE_PROHIBITED("clientDeleteProhibited"),
    CLIENT_TRANSFER_PROHIBITED("clientTransferProhibited"),
    CLIENT_UPDATE_PROHIBITED("clientUpdateProhibited"),
    LINKED("linked"),
    OK("ok"),
    PENDING_CREATE("pendingCreate"),
    PENDING_DELETE("pendingDelete"),
    PENDING_TRANSFER("pendingTransfer"),
    PENDING_UPDATE("pendingUpdate"),
    SERVER_DELETE_PROHIBITED("serverDeleteProhibited"),
    SERVER_TRANSFER_PROHIBITED("serverTransferProhibited"),
    SERVER_UPDATE_PROHIBITED("serverUpdateProhibited");

    private final String value;

    OrganizationStatusType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    private static final Map<String, OrganizationStatusType> VALUE_MAP = new HashMap<>();

    static {
        for (OrganizationStatusType type : values()) {
            VALUE_MAP.put(type.getValue(), type);
        }
    }

    @JsonCreator
    public static OrganizationStatusType fromValue(String value) {
        OrganizationStatusType type = VALUE_MAP.get(value);
        if (type == null) {
            throw new InvalidStatusException("Invalid status: " + value);
        }
        return type;
    }
}
