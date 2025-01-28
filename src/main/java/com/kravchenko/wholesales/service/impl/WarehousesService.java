package com.kravchenko.wholesales.service.impl;

import com.kravchenko.wholesales.enums.SortOrder;
import com.kravchenko.wholesales.model.Entry;
import com.kravchenko.wholesales.model.Warehouse;
import com.kravchenko.wholesales.repository.IWarehousesDAO;
import com.kravchenko.wholesales.service.IEntriesService;
import com.kravchenko.wholesales.service.IWarehousesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WarehousesService implements IWarehousesService {

    private final IWarehousesDAO repository;
    private final IEntriesService entriesService;

    @Override
    public Warehouse createWarehouse(Warehouse warehouse) {
        return repository.createWarehouse(warehouse);
    }

    @Override
    public Warehouse readWarehouseById(long id) {
        return repository.readWarehouseById(id);
    }

    @Override
    public Warehouse updateWarehouse(Warehouse warehouse) {
        return repository.updateWarehouse(warehouse);
    }

    @Override
    public void deleteWarehouseById(long id) {
        repository.deleteWarehouseById(id);
    }

    @Override
    public List< Warehouse > readAllWarehousesSorted(String sortCol, SortOrder sortOrder) {
        return repository.readAllWarehousesSorted(sortCol, sortOrder);
    }

    @Override
    public List< Entry > readAllEntriesSorted(long warehouseId, String sortCol, SortOrder sortOrder) {
        return entriesService.readWarehouseEntriesSorted(warehouseId, sortCol, sortOrder);
    }
}
