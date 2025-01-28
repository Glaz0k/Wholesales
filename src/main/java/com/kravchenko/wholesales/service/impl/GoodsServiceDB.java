package com.kravchenko.wholesales.service.impl;

import com.kravchenko.wholesales.enums.SortOrder;
import com.kravchenko.wholesales.model.Good;
import com.kravchenko.wholesales.repository.IGoodsDAO;
import com.kravchenko.wholesales.service.IGoodsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GoodsServiceDB implements IGoodsService {

    private final IGoodsDAO repository;

    @Override
    public Good createGood(Good good) {
        return repository.createGood(good);
    }

    @Override
    public Good readGoodById(long id) {
        return repository.readGoodById(id);
    }

    @Override
    public Good updateGood(Good good) {
        return repository.updateGood(good);
    }

    @Override
    public void deleteGoodById(long id) {
        repository.deleteGoodById(id);
    }

    @Override
    public List< Good > readAllGoodsSorted(String sortCol, SortOrder sortOrder) {
        return repository.readAllGoodsSorted(sortCol, sortOrder);
    }
}
