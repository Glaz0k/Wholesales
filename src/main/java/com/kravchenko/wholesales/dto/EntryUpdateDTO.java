package com.kravchenko.wholesales.dto;

public record EntryUpdateDTO(
    Long id,
    Long warehouseId,
    Long goodId,
    Long goodCount
) {

}
