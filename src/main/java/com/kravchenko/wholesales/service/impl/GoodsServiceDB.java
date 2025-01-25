package com.kravchenko.wholesales.service.impl;

import com.kravchenko.wholesales.constants.SortOrder;
import com.kravchenko.wholesales.model.Good;
import com.kravchenko.wholesales.repository.GoodsDAO;
import com.kravchenko.wholesales.service.IGoodsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GoodsServiceDB implements IGoodsService {

    private final GoodsDAO dao;

    @Override
    public Good createGood(Good good) {
        return dao.createGood(good);
    }

    @Override
    public Good readGoodById(long id) {
        return dao.readGoodById(id);
    }

    @Override
    public Good updateGood(Good good) {
        return dao.updateGood(good);
    }

    @Override
    public void deleteGoodById(long id) {
        dao.deleteGoodById(id);
    }

    @Override
    public List< Good > readAllGoodsFiltered(String sortColumn, SortOrder order) {
        return dao.readAllGoodsFiltered(sortColumn, order);
    }
}
