package com.kravchenko.wholesales.controller;

import com.kravchenko.wholesales.model.Sale;
import com.kravchenko.wholesales.service.ISalesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
@AllArgsConstructor
public class SalesController implements CRUDController< Sale > {

    private final ISalesService salesService;

    public Long create(Sale sale) {
        return salesService.createSale(sale);
    }

    public Sale readById(long id) {
        return salesService.readSaleById(id);
    }

    public void update(Sale sale) {
        salesService.updateSale(sale);
    }

    public void deleteById(long id) {
        salesService.deleteSaleById(id);
    }

    public List< Sale > readByFilter(String sortBy, boolean sortAsc) {
        Comparator< ? super Sale > cmp = Sale.getComparator(sortBy);
        return salesService.readSalesByFilter((sortAsc) ? cmp : cmp.reversed());
    }
}
