package com.kravchenko.wholesales.service;

import com.kravchenko.wholesales.dto.EntryCreateDTO;
import com.kravchenko.wholesales.dto.EntryDTO;
import com.kravchenko.wholesales.dto.EntryUpdateDTO;

import java.util.List;
import java.util.Optional;

public interface EntriesService {

    EntryDTO createEntry(EntryCreateDTO entry);

    Optional< EntryDTO > findEntryById(long id);

    boolean updateEntry(EntryUpdateDTO entry);

    boolean deleteEntryById(long id);

    List< EntryDTO > getEntriesByWarehouseId(long id);
}
