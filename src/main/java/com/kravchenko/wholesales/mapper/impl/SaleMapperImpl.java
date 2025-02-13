package com.kravchenko.wholesales.mapper.impl;

import com.kravchenko.wholesales.dto.SaleCreateDTO;
import com.kravchenko.wholesales.dto.SaleUpdateDTO;
import com.kravchenko.wholesales.entity.Sale;
import com.kravchenko.wholesales.mapper.SaleMapper;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Component;

@Component
public class SaleMapperImpl implements SaleMapper {

    @Override
    public Sale toEntity(SaleCreateDTO dto) {
        return new Sale(null,
            AggregateReference.to(dto.goodId()),
            dto.goodCount(),
            null);
    }

    @Override
    public Sale toEntity(SaleUpdateDTO dto) {
        return new Sale(dto.id(),
            AggregateReference.to(dto.goodId()),
            dto.goodCount(),
            null);
    }
}
