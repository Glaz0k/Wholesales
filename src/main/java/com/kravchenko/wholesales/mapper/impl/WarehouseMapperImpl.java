package com.kravchenko.wholesales.mapper.impl;

import com.kravchenko.wholesales.dto.WarehouseCreateDTO;
import com.kravchenko.wholesales.dto.WarehouseDTO;
import com.kravchenko.wholesales.entity.Warehouse;
import com.kravchenko.wholesales.mapper.WarehouseMapper;
import org.springframework.stereotype.Component;

@Component
public class WarehouseMapperImpl implements WarehouseMapper {

    @Override
    public Warehouse toEntity(WarehouseCreateDTO dto) {
        return new Warehouse(null);
    }

    @Override
    public WarehouseDTO toDto(Warehouse entity) {
        return new WarehouseDTO(entity.getId());
    }
}
