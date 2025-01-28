package com.kravchenko.wholesales.service;

import com.kravchenko.wholesales.enums.SortOrder;
import com.kravchenko.wholesales.model.Entry;

import java.util.List;

public interface IEntriesService {

    Entry createEntry(Entry entry);

    Entry readEntryById(long id);

    Entry updateEntry(Entry entry);

    void deleteEntryById(long id);

    List< Entry > readWarehouseEntriesSorted(long warehouseId, String sortBy, SortOrder sortOrder);
}
