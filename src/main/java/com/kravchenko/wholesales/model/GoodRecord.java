package com.kravchenko.wholesales.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class GoodRecord {

    @NonNull
    private Long id;
    @NonNull
    private Long warehouse_id;
    @NonNull
    private Long good_id;
    @NonNull
    private Long good_count;

}
