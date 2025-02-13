package com.kravchenko.wholesales.service.impl;

import com.kravchenko.wholesales.dto.GoodDTO;
import com.kravchenko.wholesales.dto.SaleCreateDTO;
import com.kravchenko.wholesales.dto.SaleDTO;
import com.kravchenko.wholesales.dto.SaleUpdateDTO;
import com.kravchenko.wholesales.entity.Sale;
import com.kravchenko.wholesales.mapper.SaleMapper;
import com.kravchenko.wholesales.repository.SalesRepository;
import com.kravchenko.wholesales.service.GoodsService;
import com.kravchenko.wholesales.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class SalesServiceImpl implements SalesService {

    private final SalesRepository repository;

    private final GoodsService goodsService;

    private final SaleMapper mapper;

    @Override
    public SaleDTO createSale(SaleCreateDTO sale) {
        Sale saleEntity = repository.save(mapper.toEntity(sale));
        return getSaleDTObyEntity(saleEntity);
    }

    @Override
    public Optional< SaleDTO > findSaleById(long id) {
        Optional< Sale > sale = repository.findById(id);
        return sale.map(this::getSaleDTObyEntity);
    }

    @Override
    public boolean updateSale(SaleUpdateDTO sale) {
        boolean isUpdated = repository.existsById(sale.id());
        repository.save(mapper.toEntity(sale));
        return isUpdated;
    }

    @Override
    public boolean deleteSaleById(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List< SaleDTO > getAllSales() {
        return StreamSupport.stream(repository.findAll().spliterator(), true)
            .map(this::getSaleDTObyEntity)
            .toList();
    }

    private SaleDTO getSaleDTObyEntity(Sale sale) {
        GoodDTO good = goodsService.findGoodById(sale.getGood().getId()).orElseThrow();
        return new SaleDTO(sale.getId(), good, sale.getGoodCount(), sale.getCreateDate());
    }
}
