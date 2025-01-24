package com.kravchenko.wholesales.controller;

import com.kravchenko.wholesales.constants.SortOrder;
import com.kravchenko.wholesales.model.Warehouse;
import com.kravchenko.wholesales.model.GoodRecord;
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
        return null;
    }

    @GetMapping("/{id}")
    public Warehouse readById(@PathVariable long id) {
        return null;
    }

    @PutMapping
    public Warehouse update(@RequestBody Warehouse warehouse) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {

    }

    @GetMapping
    public List< Warehouse > readAll() {
        return null;
    }

    @GetMapping("/{id}/records")
    public List< GoodRecord > readRecordsBy(@PathVariable long id,
                                            @RequestParam(defaultValue = "ID") String orderBy,
                                            @RequestParam(defaultValue = "ASC") SortOrder sortOrder) {
        return null;
    }

}
