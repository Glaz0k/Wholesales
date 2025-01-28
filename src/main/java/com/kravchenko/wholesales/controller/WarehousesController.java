package com.kravchenko.wholesales.controller;

import com.kravchenko.wholesales.enums.SortOrder;
import com.kravchenko.wholesales.model.Entry;
import com.kravchenko.wholesales.model.Warehouse;
import com.kravchenko.wholesales.service.IWarehousesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
@AllArgsConstructor
public class WarehousesController {

    private final IWarehousesService warehousesService;

    @PostMapping
    public Warehouse create(@RequestBody Warehouse warehouse) {
        return warehousesService.createWarehouse(warehouse);
    }

    @GetMapping("/{id}")
    public Warehouse readById(@PathVariable long id) {
        return warehousesService.readWarehouseById(id);
    }

    @PutMapping
    public Warehouse update(@RequestBody Warehouse warehouse) {
        return warehousesService.updateWarehouse(warehouse);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        warehousesService.deleteWarehouseById(id);
    }

    @GetMapping
    public List< Warehouse > readAllSorted(@RequestParam(defaultValue = "id") String sortCol,
                                           @RequestParam(defaultValue = "ASC") SortOrder sortOrder) {
        return warehousesService.readAllWarehousesSorted(sortCol, sortOrder);
    }

    @GetMapping("/{id}/entries")
    public List< Entry > readAllEntriesSorted(@PathVariable long id,
                                              @RequestParam(defaultValue = "id") String sortCol,
                                              @RequestParam(defaultValue = "ASC") SortOrder sortOrder) {
        return warehousesService.readAllEntriesSorted(id, sortCol, sortOrder);
    }

}
