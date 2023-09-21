package com.spring.board.eia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DemographicDataType {
    gender("Gender"),
    racial("Racial"),
    age("Age");
    private final String displayName;
}
