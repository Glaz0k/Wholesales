package com.kravchenko.wholesales.service;

import com.kravchenko.wholesales.dto.EntryDTO;
import com.kravchenko.wholesales.dto.WarehouseCreateDTO;
import com.kravchenko.wholesales.dto.WarehouseDTO;

import java.util.List;
import java.util.Optional;

public interface WarehousesService {

    WarehouseDTO createWarehouse(WarehouseCreateDTO warehouse);

    Optional< WarehouseDTO > findWarehouseById(long id);

    boolean deleteWarehouseById(long id);

    List< WarehouseDTO > getAllWarehouses();

    List< EntryDTO > getAllWarehouseEntries(long id);
}
