package com.kravchenko.wholesales.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class WarehouseRecord {

    @NonNull
    private Long id;
    @NonNull
    private Long good_id;
    @NonNull
    private Long good_count;

}
