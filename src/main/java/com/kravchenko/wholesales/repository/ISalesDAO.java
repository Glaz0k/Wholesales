package com.kravchenko.wholesales.repository;

import com.kravchenko.wholesales.enums.SortOrder;
import com.kravchenko.wholesales.model.Sale;

import java.util.List;

public interface ISalesDAO {

    Sale createSale(Sale sale);

    Sale readSaleById(long id);

    Sale updateSale(Sale sale);

    void deleteSaleById(long id);

    List< Sale > readAllSalesSorted(String sortCol, SortOrder sortOrder);

}
