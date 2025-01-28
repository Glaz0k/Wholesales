package com.kravchenko.wholesales.service;

import com.kravchenko.wholesales.enums.SortOrder;
import com.kravchenko.wholesales.model.Good;

import java.util.List;

public interface IGoodsService {

    Good createGood(Good good);

    Good readGoodById(long id);

    Good updateGood(Good good);

    void deleteGoodById(long id);

    List< Good > readAllGoodsSorted(String sortCol, SortOrder sortOrder);
}
