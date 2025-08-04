package com.peterpopma.easysix.organization.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.peterpopma.easysix.organization.exception.InvalidStatusException;

import java.util.HashMap;
import java.util.Map;

public enum OrganizationRoleStatusType {
    OK("ok"),
    CLIENT_LINK_PROHIBITED("clientLinkProhibited"),
    LINKED("linked"),
    SERVER_LINK_PROHIBITED("serverLinkProhibited");

    private final String value;

    OrganizationRoleStatusType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    private static final Map<String, OrganizationRoleStatusType> VALUE_MAP = new HashMap<>();

    static {
        for (OrganizationRoleStatusType type : values()) {
            VALUE_MAP.put(type.getValue(), type);
        }
    }

    @JsonCreator
    public static OrganizationRoleStatusType fromValue(String value) {
        OrganizationRoleStatusType type = VALUE_MAP.get(value);
        if (type == null) {
            throw new InvalidStatusException("Invalid status: " + value);
        }
        return type;
    }
}
