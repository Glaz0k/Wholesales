package com.kravchenko.wholesales.model;

import lombok.NonNull;

public record Good(
        @NonNull Long id,
        @NonNull String name,
        @NonNull Float priority
) {

}
