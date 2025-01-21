package com.kravchenko.wholesales.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Good {

    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Float priority;
}
