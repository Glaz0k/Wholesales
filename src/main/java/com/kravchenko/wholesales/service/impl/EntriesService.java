package com.kravchenko.wholesales.service.impl;

import com.kravchenko.wholesales.enums.SortOrder;
import com.kravchenko.wholesales.model.Entry;
import com.kravchenko.wholesales.repository.IEntriesDAO;
import com.kravchenko.wholesales.service.IEntriesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EntriesService implements IEntriesService {

    private final IEntriesDAO repository;

    @Override
    public Entry createEntry(Entry entry) {
        return repository.createEntry(entry);
    }

    @Override
    public Entry readEntryById(long id) {
        return repository.readEntryById(id);
    }

    @Override
    public Entry updateEntry(Entry entry) {
        return repository.updateEntry(entry);
    }

    @Override
    public void deleteEntryById(long id) {
        repository.deleteEntryById(id);
    }

    @Override
    public List< Entry > readWarehouseEntriesSorted(long warehouseId, String sortBy, SortOrder sortOrder) {
        return repository.readWarehouseEntriesSorted(warehouseId, sortBy, sortOrder);
    }
}
