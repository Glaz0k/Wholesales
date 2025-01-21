package com.kravchenko.wholesales.service;

import com.kravchenko.wholesales.model.Good;

public interface IGoodsService {

    Long createGood(Good good);
    Good readGoodById(long id);
    void updateGood(Good good);
    void deleteGoodById(long id);
}
