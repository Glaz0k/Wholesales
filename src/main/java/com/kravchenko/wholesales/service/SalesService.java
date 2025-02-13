package com.kravchenko.wholesales.service;

import com.kravchenko.wholesales.dto.SaleCreateDTO;
import com.kravchenko.wholesales.dto.SaleDTO;
import com.kravchenko.wholesales.dto.SaleUpdateDTO;

import java.util.List;
import java.util.Optional;

public interface SalesService {

    SaleDTO createSale(SaleCreateDTO sale);

    Optional< SaleDTO > findSaleById(long id);

    boolean updateSale(SaleUpdateDTO sale);

    boolean deleteSaleById(long id);

    List< SaleDTO > getAllSales();
}
