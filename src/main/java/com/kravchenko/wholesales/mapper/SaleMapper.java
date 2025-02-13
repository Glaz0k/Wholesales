package com.kravchenko.wholesales.mapper;

import com.kravchenko.wholesales.dto.SaleCreateDTO;
import com.kravchenko.wholesales.dto.SaleUpdateDTO;
import com.kravchenko.wholesales.entity.Sale;

public interface SaleMapper {

    Sale toEntity(SaleCreateDTO dto);

    Sale toEntity(SaleUpdateDTO dto);

}
