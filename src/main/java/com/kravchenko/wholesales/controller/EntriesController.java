package com.kravchenko.wholesales.controller;

import com.kravchenko.wholesales.dto.EntryCreateDTO;
import com.kravchenko.wholesales.dto.EntryDTO;
import com.kravchenko.wholesales.dto.EntryUpdateDTO;
import com.kravchenko.wholesales.service.EntriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/entries")
@RequiredArgsConstructor
public class EntriesController {

    private final EntriesService entriesService;

    @PostMapping
    public EntryDTO create(@RequestBody EntryCreateDTO entry) {
        return entriesService.createEntry(entry);
    }

    @GetMapping("/{id}")
    public EntryDTO readById(@PathVariable long id) {
        return entriesService.findEntryById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id,
                       @RequestBody EntryCreateDTO entry) {
        EntryUpdateDTO dto = new EntryUpdateDTO(id, entry.warehouseId(), entry.goodId(), entry.goodCount());
        if (!entriesService.updateEntry(dto)) {
            throw new ResponseStatusException(HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        entriesService.deleteEntryById(id);
    }

}
