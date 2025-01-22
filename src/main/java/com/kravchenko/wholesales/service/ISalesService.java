package com.kravchenko.wholesales.service;

import com.kravchenko.wholesales.model.Sale;

import java.util.Comparator;
import java.util.List;

public interface ISalesService {

    Long createSale(Sale sale);

    Sale readSaleById(long id);

    void updateSale(Sale sale);

    void deleteSaleById(long id);

    List< Sale > readSalesByFilter(Comparator< ? super Sale > cmp);
}
