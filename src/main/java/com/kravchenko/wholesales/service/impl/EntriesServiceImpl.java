package com.kravchenko.wholesales.service.impl;

import com.kravchenko.wholesales.dto.EntryCreateDTO;
import com.kravchenko.wholesales.dto.EntryDTO;
import com.kravchenko.wholesales.dto.EntryUpdateDTO;
import com.kravchenko.wholesales.entity.Entry;
import com.kravchenko.wholesales.mapper.EntryMapper;
import com.kravchenko.wholesales.mapper.GoodMapper;
import com.kravchenko.wholesales.mapper.WarehouseMapper;
import com.kravchenko.wholesales.repository.EntriesRepository;
import com.kravchenko.wholesales.repository.GoodsRepository;
import com.kravchenko.wholesales.repository.WarehousesRepository;
import com.kravchenko.wholesales.service.EntriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EntriesServiceImpl implements EntriesService {

    private final EntriesRepository repository;

    private final EntryMapper mapper;

    // TODO: Refactor these mess
    private final GoodsRepository goodsRepository;

    private final WarehousesRepository warehousesRepository;

    private final GoodMapper goodMapper;

    private final WarehouseMapper warehouseMapper;

    @Override
    public EntryDTO createEntry(EntryCreateDTO entry) {
        return getEntryDtoByEntity(repository.save(mapper.toEntity(entry)));
    }

    @Override
    public Optional< EntryDTO > findEntryById(long id) {
        return repository.findById(id).map(this::getEntryDtoByEntity);
    }

    @Override
    public boolean updateEntry(EntryUpdateDTO entry) {
        boolean isUpdated = !repository.existsById(entry.id());
        repository.save(mapper.toEntity(entry));
        return isUpdated;
    }

    @Override
    public boolean deleteEntryById(long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public List< EntryDTO > getEntriesByWarehouseId(long id) {
        return repository.findByWarehouseId(id).parallelStream()
            .map(this::getEntryDtoByEntity)
            .toList();
    }

    private EntryDTO getEntryDtoByEntity(Entry entry) {
        return new EntryDTO(entry.getId(),
            warehouseMapper.toDto(warehousesRepository.findById(entry.getWarehouse().getId()).orElseThrow()),
            goodMapper.toDto(goodsRepository.findById(entry.getGood().getId()).orElseThrow()),
            entry.getGoodCount());
    }
}
