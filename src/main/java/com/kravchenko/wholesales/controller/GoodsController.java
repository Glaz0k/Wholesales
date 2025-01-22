package com.kravchenko.wholesales.controller;

import com.kravchenko.wholesales.model.Good;
import com.kravchenko.wholesales.service.IGoodsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/goods")
@AllArgsConstructor
public class GoodsController implements CRUDController< Good > {

    private final IGoodsService goodsService;

    public Long create(Good good) {
        return goodsService.createGood(good);
    }

    public Good readById(long id) {
        return goodsService.readGoodById(id);
    }

    public void update(Good good) {
        goodsService.updateGood(good);
    }

    public void deleteById(long id) {
        goodsService.deleteGoodById(id);
    }

    public List< Good > readByFilter(String sortBy, boolean sortAsc) {
        Comparator< ? super Good > cmp = Good.getComparator(sortBy);
        return goodsService.readGoodsByFilter((sortAsc) ? cmp : cmp.reversed());
    }
}
