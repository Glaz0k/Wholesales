package com.kravchenko.wholesales.mapper.impl;

import com.kravchenko.wholesales.dto.GoodCreateDTO;
import com.kravchenko.wholesales.dto.GoodDTO;
import com.kravchenko.wholesales.entity.Good;
import com.kravchenko.wholesales.mapper.GoodMapper;
import org.springframework.stereotype.Component;

@Component
public class GoodMapperImpl implements GoodMapper {

    @Override
    public Good toEntity(GoodDTO dto) {
        return new Good(dto.id(),
            dto.name(),
            dto.priority());
    }

    @Override
    public Good toEntity(GoodCreateDTO dto) {
        return new Good(null,
            dto.name(),
            dto.priority());
    }

    @Override
    public GoodDTO toDto(Good entity) {
        return new GoodDTO(entity.getId(),
            entity.getName(),
            entity.getPriority());
    }
}
