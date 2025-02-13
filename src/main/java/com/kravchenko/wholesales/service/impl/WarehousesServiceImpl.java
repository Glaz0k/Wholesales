package com.kravchenko.wholesales.service.impl;

import com.kravchenko.wholesales.dto.EntryDTO;
import com.kravchenko.wholesales.dto.WarehouseCreateDTO;
import com.kravchenko.wholesales.dto.WarehouseDTO;
import com.kravchenko.wholesales.mapper.WarehouseMapper;
import com.kravchenko.wholesales.repository.WarehousesRepository;
import com.kravchenko.wholesales.service.EntriesService;
import com.kravchenko.wholesales.service.WarehousesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class WarehousesServiceImpl implements WarehousesService {

    private final WarehousesRepository repository;

    private final WarehouseMapper mapper;

    private final EntriesService entriesService;

    @Override
    public WarehouseDTO createWarehouse(WarehouseCreateDTO warehouse) {
        return mapper.toDto(repository.save(mapper.toEntity(warehouse)));
    }

    @Override
    public Optional< WarehouseDTO > findWarehouseById(long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Override
    public boolean deleteWarehouseById(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List< WarehouseDTO > getAllWarehouses() {
        return StreamSupport.stream(repository.findAll().spliterator(), true)
            .map(mapper::toDto)
            .toList();
    }

    @Override
    public List< EntryDTO > getAllWarehouseEntries(long id) {
        return entriesService.getEntriesByWarehouseId(id);
    }
}
