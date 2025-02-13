package com.kravchenko.wholesales.mapper.impl;

import com.kravchenko.wholesales.dto.EntryCreateDTO;
import com.kravchenko.wholesales.dto.EntryUpdateDTO;
import com.kravchenko.wholesales.entity.Entry;
import com.kravchenko.wholesales.mapper.EntryMapper;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Component;

@Component
public class EntryMapperImpl implements EntryMapper {

    @Override
    public Entry toEntity(EntryCreateDTO dto) {
        return new Entry(null,
            AggregateReference.to(dto.warehouseId()),
            AggregateReference.to(dto.goodId()),
            dto.goodCount());
    }

    @Override
    public Entry toEntity(EntryUpdateDTO dto) {
        return new Entry(dto.id(),
            AggregateReference.to(dto.warehouseId()),
            AggregateReference.to(dto.goodId()),
            dto.goodCount());
    }
}
