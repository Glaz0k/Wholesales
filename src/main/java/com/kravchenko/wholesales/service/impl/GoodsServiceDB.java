package com.kravchenko.wholesales.service.impl;

import com.kravchenko.wholesales.model.Good;
import com.kravchenko.wholesales.repository.GoodsDAO;
import com.kravchenko.wholesales.service.IGoodsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GoodsServiceDB implements IGoodsService {

    private final GoodsDAO dao;

    @Override
    public Long createGood(Good good) {
        return dao.createGood(good);
    }

    @Override
    public Good readGoodById(long id) {
        return dao.readGoodById(id);
    }

    @Override
    public void updateGood(Good good) {
        dao.updateGood(good);
    }

    @Override
    public void deleteGoodById(long id) {
        dao.deleteGoodById(id);
    }
}
