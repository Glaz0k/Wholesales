package com.kravchenko.wholesales.service;

import com.kravchenko.wholesales.model.Good;

import java.util.Comparator;
import java.util.List;

public interface IGoodsService {

    Long createGood(Good good);
    Good readGoodById(long id);
    void updateGood(Good good);
    void deleteGoodById(long id);
    List<Good> readGoodsByFilter(Comparator< ? super Good > cmp);
}
