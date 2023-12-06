package com.wide.cakeapplication.infrastructure.enums;

import lombok.Getter;

@Getter
public enum IdentityEnum {
    USER("0","User"),
    EMPLOYEE("1","Employee");
    private final String identityCode;
    private final String identityString;

    IdentityEnum(String code,String identity) {
        this.identityCode = code;this.identityString = identity;
    }
}
