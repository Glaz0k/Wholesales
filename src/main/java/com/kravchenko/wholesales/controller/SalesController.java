package com.kravchenko.wholesales.controller;

import com.kravchenko.wholesales.model.Sale;
import com.kravchenko.wholesales.service.ISalesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
@AllArgsConstructor
public class SalesController {

    private final ISalesService salesService;

    @PostMapping
    public Long create(@RequestBody Sale sale) {
        return salesService.createSale(sale);
    }

    @GetMapping("/{id}")
    public Sale readById(@PathVariable long id) {
        return salesService.readSaleById(id);
    }

    @PutMapping
    public void update(@RequestBody Sale sale) {
        salesService.updateSale(sale);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        salesService.deleteSaleById(id);
    }

    @GetMapping
    public List< Sale > readByFilter(@RequestParam(defaultValue = "ID") String sortBy,
                                     @RequestParam(defaultValue = "true") boolean sortAsc) {
        Comparator< ? super Sale > cmp = Sale.getComparator(sortBy);
        return salesService.readSalesByFilter((sortAsc) ? cmp : cmp.reversed());
    }
}
