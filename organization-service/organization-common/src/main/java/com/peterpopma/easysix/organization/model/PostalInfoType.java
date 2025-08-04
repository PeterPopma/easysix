package com.peterpopma.easysix.organization.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Map;
import java.util.HashMap;

public enum PostalInfoType {
    LOC("loc"),
    INT("int");

    private final String value;

    PostalInfoType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    private static final Map<String, PostalInfoType> VALUE_MAP = new HashMap<>();

    static {
        for (PostalInfoType type : values()) {
            VALUE_MAP.put(type.getValue(), type);
        }
    }

    @JsonCreator
    public static PostalInfoType fromValue(String value) {
        PostalInfoType type = VALUE_MAP.get(value);
        if (type == null) {
            throw new IllegalArgumentException("Invalid postalInfoType: " + value);
        }
        return type;
    }
}
