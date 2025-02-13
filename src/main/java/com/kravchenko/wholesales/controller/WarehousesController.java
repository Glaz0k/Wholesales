package com.kravchenko.wholesales.controller;

import com.kravchenko.wholesales.dto.EntryDTO;
import com.kravchenko.wholesales.dto.WarehouseCreateDTO;
import com.kravchenko.wholesales.dto.WarehouseDTO;
import com.kravchenko.wholesales.service.WarehousesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
@RequiredArgsConstructor
public class WarehousesController {

    private final WarehousesService warehousesService;

    @PostMapping
    public WarehouseDTO create(@RequestBody WarehouseCreateDTO warehouse) {
        return warehousesService.createWarehouse(warehouse);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        warehousesService.deleteWarehouseById(id);
    }

    @GetMapping
    public List< WarehouseDTO > readAll() {
        return warehousesService.getAllWarehouses();
    }

    @GetMapping("/{id}/entries")
    public List< EntryDTO > readAllWarehouseEntries(@PathVariable long id) {
        return warehousesService.getAllWarehouseEntries(id);
    }

}
