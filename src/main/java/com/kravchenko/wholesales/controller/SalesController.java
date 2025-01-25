package com.kravchenko.wholesales.controller;

import com.kravchenko.wholesales.constants.SortOrder;
import com.kravchenko.wholesales.model.Sale;
import com.kravchenko.wholesales.service.ISalesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@AllArgsConstructor
public class SalesController {

    private final ISalesService salesService;

    @PostMapping
    public Sale create(@RequestBody Sale sale) {
        return salesService.createSale(sale);
    }

    @GetMapping("/{id}")
    public Sale readById(@PathVariable long id) {
        return salesService.readSaleById(id);
    }

    @PutMapping
    public Sale update(@RequestBody Sale sale) {
        return salesService.updateSale(sale);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        salesService.deleteSaleById(id);
    }

    @GetMapping
    public List< Sale > readByFilter(@RequestParam String sortBy,
                                     @RequestParam SortOrder sortOrder) {
        return salesService.readAllSalesFiltered(sortBy, sortOrder);
    }
}
