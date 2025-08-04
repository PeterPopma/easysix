package com.peterpopma.easysix.organization.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Map;
import java.util.HashMap;

public enum OrganizationContactType {
    ADMIN("admin"),
    TECH("tech"),
    BILLING("billing"),
    ABUSE("abuse"),
    CUSTOM("custom");

    private final String value;

    OrganizationContactType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    private static final Map<String, OrganizationContactType> VALUE_MAP = new HashMap<>();

    static {
        for (OrganizationContactType type : values()) {
            VALUE_MAP.put(type.getValue(), type);
        }
    }

    @JsonCreator
    public static OrganizationContactType fromValue(String value) {
        OrganizationContactType type = VALUE_MAP.get(value);
        if (type == null) {
            throw new IllegalArgumentException("Invalid OrganizationContactType: " + value);
        }
        return type;
    }
}
