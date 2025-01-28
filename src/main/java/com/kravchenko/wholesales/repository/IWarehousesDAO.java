package com.kravchenko.wholesales.repository;

import com.kravchenko.wholesales.enums.SortOrder;
import com.kravchenko.wholesales.model.Warehouse;

import java.util.List;

public interface IWarehousesDAO {

    Warehouse createWarehouse(Warehouse warehouse);

    Warehouse readWarehouseById(long id);

    Warehouse updateWarehouse(Warehouse warehouse);

    void deleteWarehouseById(long id);

    List< Warehouse > readAllWarehousesSorted(String sortCol, SortOrder sortOrder);

}
