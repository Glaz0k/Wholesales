package com.kravchenko.wholesales.service.impl;

import com.kravchenko.wholesales.constants.SortOrder;
import com.kravchenko.wholesales.model.Sale;
import com.kravchenko.wholesales.repository.SalesDAO;
import com.kravchenko.wholesales.service.ISalesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class SalesServiceDB implements ISalesService {

    private final SalesDAO repository;

    @Override
    public Sale createSale(Sale sale) {
        return repository.createSale(sale);
    }

    @Override
    public Sale readSaleById(long id) {
        return repository.readSaleById(id);
    }

    @Override
    public Sale updateSale(Sale sale) {
        return repository.updateSale(sale);
    }

    @Override
    public void deleteSaleById(long id) {
        repository.deleteSaleById(id);
    }

    @Override
    public List< Sale > readAllSalesFiltered(String sortColumn, SortOrder order) {
        return repository.readSaleByFilter(sortColumn, order);
    }
}
