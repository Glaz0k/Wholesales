package com.kravchenko.wholesales.repository;

import com.kravchenko.wholesales.enums.SortOrder;
import com.kravchenko.wholesales.model.Entry;

import java.util.List;

public interface IEntriesDAO {

    Entry createEntry(Entry entry);

    Entry readEntryById(long id);

    Entry updateEntry(Entry entry);

    void deleteEntryById(long id);

    List< Entry > readWarehouseEntriesSorted(long warehouseId, String sortBy, SortOrder sortOrder);
}
