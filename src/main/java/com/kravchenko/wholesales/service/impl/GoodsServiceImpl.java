package com.kravchenko.wholesales.service.impl;

import com.kravchenko.wholesales.dto.GoodCreateDTO;
import com.kravchenko.wholesales.dto.GoodDTO;
import com.kravchenko.wholesales.mapper.GoodMapper;
import com.kravchenko.wholesales.repository.GoodsRepository;
import com.kravchenko.wholesales.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository repository;

    private final GoodMapper mapper;

    @Override
    public GoodDTO createGood(GoodCreateDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public Optional< GoodDTO > findGoodById(long id) {
        return repository.findById(id)
            .map(mapper::toDto);
    }

    @Override
    public boolean updateGood(GoodDTO dto) {
        boolean isUpdated = repository.existsById(dto.id());
        repository.save(mapper.toEntity(dto));
        return isUpdated;
    }

    @Override
    public boolean deleteGoodById(long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public List< GoodDTO > getAllGoods() {
        return StreamSupport.stream(repository.findAll().spliterator(), true)
            .map(mapper::toDto)
            .toList();
    }

}
