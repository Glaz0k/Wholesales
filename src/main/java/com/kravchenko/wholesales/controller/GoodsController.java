package com.kravchenko.wholesales.controller;

import com.kravchenko.wholesales.dto.GoodCreateDTO;
import com.kravchenko.wholesales.dto.GoodDTO;
import com.kravchenko.wholesales.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/goods")
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    @PostMapping
    public GoodDTO create(@RequestBody GoodCreateDTO good) {
        return goodsService.createGood(good);
    }

    @GetMapping("/{id}")
    public GoodDTO readById(@PathVariable long id) {
        return goodsService.findGoodById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id,
                       @RequestBody GoodCreateDTO good) {
        GoodDTO dto = new GoodDTO(id, good.name(), good.priority());
        if (!goodsService.updateGood(dto)) {
            throw new ResponseStatusException(HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        goodsService.deleteGoodById(id);
    }

    @GetMapping
    public List< GoodDTO > readAll() {
        return goodsService.getAllGoods();
    }
}
