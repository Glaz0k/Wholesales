package com.kravchenko.wholesales.controller;

import com.kravchenko.wholesales.enums.SortOrder;
import com.kravchenko.wholesales.model.Good;
import com.kravchenko.wholesales.service.IGoodsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goods")
@AllArgsConstructor
public class GoodsController {

    private final IGoodsService goodsService;

    @PostMapping
    public Good create(@RequestBody Good good) {
        return goodsService.createGood(good);
    }

    @GetMapping("/{id}")
    public Good readById(@PathVariable long id) {
        return goodsService.readGoodById(id);
    }

    @PutMapping
    public Good update(@RequestBody Good good) {
        return goodsService.updateGood(good);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        goodsService.deleteGoodById(id);
    }

    @GetMapping
    public List< Good > readAllSorted(@RequestParam(defaultValue = "id") String sortCol,
                                      @RequestParam(defaultValue = "ASC") SortOrder sortOrder) {
        return goodsService.readAllGoodsSorted(sortCol, sortOrder);
    }
}
