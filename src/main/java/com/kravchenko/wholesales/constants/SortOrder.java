package com.kravchenko.wholesales.constants;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SortOrder {

    ASCENDING("ASC"),
    DESCENDING("DESC");

    private final String name;
}
