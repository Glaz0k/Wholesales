package com.kravchenko.wholesales.mapper;

import com.kravchenko.wholesales.dto.GoodCreateDTO;
import com.kravchenko.wholesales.dto.GoodDTO;
import com.kravchenko.wholesales.entity.Good;

public interface GoodMapper {

    Good toEntity(GoodDTO dto);

    Good toEntity(GoodCreateDTO dto);

    GoodDTO toDto(Good entity);

}
