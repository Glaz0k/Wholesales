package com.kravchenko.wholesales.service;

import com.kravchenko.wholesales.dto.GoodCreateDTO;
import com.kravchenko.wholesales.dto.GoodDTO;

import java.util.List;
import java.util.Optional;

public interface GoodsService {

    GoodDTO createGood(GoodCreateDTO dto);

    Optional< GoodDTO > findGoodById(long id);

    boolean updateGood(GoodDTO dto);

    boolean deleteGoodById(long id);

    List< GoodDTO > getAllGoods();
}
