package com.kravchenko.wholesales.controller;

import com.kravchenko.wholesales.dto.SaleCreateDTO;
import com.kravchenko.wholesales.dto.SaleDTO;
import com.kravchenko.wholesales.dto.SaleUpdateDTO;
import com.kravchenko.wholesales.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SalesController {

    private final SalesService salesService;

    @PostMapping
    public SaleDTO create(@RequestBody SaleCreateDTO sale) {
        return salesService.createSale(sale);
    }

    @GetMapping("/{id}")
    public SaleDTO readById(@PathVariable long id) {
        return salesService.findSaleById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id,
                       @RequestBody SaleCreateDTO sale) {
        SaleUpdateDTO dto = new SaleUpdateDTO(id, sale.goodId(), sale.goodCount());
        if (!salesService.updateSale(dto)) {
            throw new ResponseStatusException(HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        salesService.deleteSaleById(id);
    }

    @GetMapping
    public List< SaleDTO > readAll() {
        return salesService.getAllSales();
    }
}
