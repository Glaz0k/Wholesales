package com.kravchenko.wholesales.controller;

import com.kravchenko.wholesales.model.WarehouseRecord;
import com.kravchenko.wholesales.service.IWarehousesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
@AllArgsConstructor
public class WarehousesController {

    private final IWarehousesService warehousesService;

    @GetMapping
    public List< Long > readWarehousesIds() {
        return null;
    }

    @PostMapping("/{warehouseId}/records")
    public Long createRecord(@PathVariable long warehouseId,
                             @RequestBody WarehouseRecord record) {
        return null;
    }

    @GetMapping("/{warehouseId}/records/{id}")
    public WarehouseRecord readRecordById(@PathVariable long warehouseId,
                                          @PathVariable long id) {
        return null;
    }

    @PutMapping("/{warehouseId}/records")
    public void updateRecord(@PathVariable long warehouseId,
                             @RequestBody WarehouseRecord record) {

    }

    @DeleteMapping("/{warehouseId}/records/{id}")
    public void deleteRecord(@PathVariable long warehouseId,
                             @PathVariable long id) {

    }

    @GetMapping("/{warehouseId}/records")
    public List< WarehouseRecord > readRecordsBy(@PathVariable long warehouseId,
                                                 @RequestParam(defaultValue = "ID") String sortBy,
                                                 @RequestParam(defaultValue = "true") boolean sortAsc) {
        return null;
    }

}
