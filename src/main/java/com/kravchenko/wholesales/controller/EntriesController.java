package com.kravchenko.wholesales.controller;

import com.kravchenko.wholesales.model.Entry;
import com.kravchenko.wholesales.service.IEntriesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entries")
@AllArgsConstructor
public class EntriesController {

    private final IEntriesService entriesService;

    @PostMapping
    public Entry create(@RequestBody Entry entry) {
        return entriesService.createEntry(entry);
    }

    @GetMapping("/{id}")
    public Entry readById(@PathVariable long id) {
        return entriesService.readEntryById(id);
    }

    @PutMapping
    public Entry update(@RequestBody Entry entry) {
        return entriesService.updateEntry(entry);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        entriesService.deleteEntryById(id);
    }

}
