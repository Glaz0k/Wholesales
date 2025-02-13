package com.kravchenko.wholesales.dto;

public record EntryDTO(
    Long id,
    WarehouseDTO warehouse,
    GoodDTO good,
    Long goodCount
) {

}
