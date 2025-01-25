package com.kravchenko.wholesales.service;

import com.kravchenko.wholesales.constants.SortOrder;
import com.kravchenko.wholesales.model.Sale;

import java.util.List;

public interface ISalesService {

    Sale createSale(Sale sale);

    Sale readSaleById(long id);

    Sale updateSale(Sale sale);

    void deleteSaleById(long id);

    List< Sale > readAllSalesFiltered(String sortColumn, SortOrder order);
}
