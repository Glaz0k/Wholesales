package com.kravchenko.wholesales.service;

import com.kravchenko.wholesales.enums.SortOrder;
import com.kravchenko.wholesales.model.Entry;
import com.kravchenko.wholesales.model.Warehouse;

import java.util.List;

public interface IWarehousesService {

    Warehouse createWarehouse(Warehouse warehouse);

    Warehouse readWarehouseById(long id);

    Warehouse updateWarehouse(Warehouse warehouse);

    void deleteWarehouseById(long id);

    List< Warehouse > readAllWarehousesSorted(String sortCol, SortOrder sortOrder);

    List< Entry > readAllEntriesSorted(long warehouseId, String sortCol, SortOrder sortOrder);
}
