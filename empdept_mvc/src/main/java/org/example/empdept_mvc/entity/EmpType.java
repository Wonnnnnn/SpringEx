package org.example.empdept_mvc.entity;

import lombok.Getter;

public enum EmpType {
    A("사원"),
    B("임원"),
    C("대표");

    @Getter
    private final String description;

    EmpType(String description) {
        this.description = description;
    }
}
