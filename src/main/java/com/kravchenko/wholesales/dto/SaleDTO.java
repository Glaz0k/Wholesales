package com.kravchenko.wholesales.dto;

import java.sql.Timestamp;

public record SaleDTO(
    Long id,
    GoodDTO good,
    Long goodCount,
    Timestamp createDate
) {

}
