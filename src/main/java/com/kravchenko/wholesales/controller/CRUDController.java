package com.kravchenko.wholesales.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CRUDController< Entity > {

    @PostMapping
    Long create(@RequestBody Entity entity);

    @GetMapping("/{id}")
    Entity readById(@RequestParam long id);

    @PutMapping
    void update(@RequestBody Entity entity);

    @DeleteMapping("/{id}")
    void deleteById(@RequestParam long id);

    @GetMapping("/filter")
    List< Entity > readByFilter(@RequestParam(defaultValue = "ID") String sortBy,
                                @RequestParam(defaultValue = "true") boolean sortAsc);
}
