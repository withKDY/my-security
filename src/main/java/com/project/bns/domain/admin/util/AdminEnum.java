package com.project.bns.domain.admin.util;

import lombok.Getter;

@Getter
public enum AdminEnum {
    ACTIVE("A"), NOT_ACTIVE("D");

    public String role;

    AdminEnum(String role) {
        this.role = role;
    }
}
