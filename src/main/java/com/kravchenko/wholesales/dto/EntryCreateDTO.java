package com.kravchenko.wholesales.dto;

public record EntryCreateDTO(
    Long warehouseId,
    Long goodId,
    Long goodCount
) {

}
