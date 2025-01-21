package com.kravchenko.wholesales.controller;

import com.kravchenko.wholesales.model.Good;
import com.kravchenko.wholesales.service.IGoodsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/goods")
@AllArgsConstructor
public class GoodsController {

    private final IGoodsService goodsService;

    @PostMapping
    public Long createGood(@RequestBody Good good) {
        return goodsService.createGood(good);
    }

    @GetMapping
    public Good readGoodById(@RequestParam long id) {
        return goodsService.readGoodById(id);
    }

    @PutMapping
    public void updateGood(@RequestBody Good good) {
        goodsService.updateGood(good);
    }

    @DeleteMapping
    public void deleteGoodById(@RequestParam long id) {
        goodsService.deleteGoodById(id);
    }
}
