package com.kravchenko.wholesales.controller;

import com.kravchenko.wholesales.model.Good;
import com.kravchenko.wholesales.service.IGoodsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/goods")
@AllArgsConstructor
public class GoodsController {

    private final IGoodsService goodsService;

    @PostMapping
    public Long createGood(@RequestBody Good good) {
        return goodsService.createGood(good);
    }

    @GetMapping("/{id}")
    public Good readGoodById(@PathVariable long id) {
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

    @GetMapping
    public List<Good> readGoodsByFilter(@RequestParam(defaultValue = "ID") String sortBy,
                                        @RequestParam(defaultValue = "true") boolean sortAsc) {
        Comparator< ? super Good > cmp = Good.getComparator(sortBy);
        return goodsService.readGoodsByFilter((sortAsc) ? cmp : cmp.reversed());
    }
}
