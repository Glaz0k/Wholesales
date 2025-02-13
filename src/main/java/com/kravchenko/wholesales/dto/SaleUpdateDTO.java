package com.kravchenko.wholesales.dto;

public record SaleUpdateDTO(
    Long id,
    Long goodId,
    Long goodCount
) {

}
