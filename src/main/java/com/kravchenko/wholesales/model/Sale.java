package com.kravchenko.wholesales.model;

import lombok.Builder;
import lombok.NonNull;

import java.sql.Timestamp;

@Builder
public record Sale(
        @NonNull Long id,
        @NonNull Long good_id,
        @NonNull Long good_count,
        @NonNull Timestamp create_date
) {

}
