package com.kravchenko.wholesales.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SortOrder {

    ASCENDING("ASC"),
    DESCENDING("DESC");

    private final String name;
}
