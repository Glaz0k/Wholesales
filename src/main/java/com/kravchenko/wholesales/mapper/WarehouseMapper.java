package com.kravchenko.wholesales.mapper;

import com.kravchenko.wholesales.dto.WarehouseCreateDTO;
import com.kravchenko.wholesales.dto.WarehouseDTO;
import com.kravchenko.wholesales.entity.Warehouse;

public interface WarehouseMapper {

    Warehouse toEntity(WarehouseCreateDTO dto);

    WarehouseDTO toDto(Warehouse entity);

}
