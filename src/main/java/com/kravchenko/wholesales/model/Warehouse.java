package com.kravchenko.wholesales.model;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record Warehouse(
    @NonNull Long id
) {

}
