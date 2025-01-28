package com.kravchenko.wholesales.model;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record Entry(
        @NonNull Long id,
        @NonNull Long warehouse_id,
        @NonNull Long good_id,
        @NonNull Long good_count
) {

}
