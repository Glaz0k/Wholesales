package com.kravchenko.wholesales.mapper;

import com.kravchenko.wholesales.dto.EntryCreateDTO;
import com.kravchenko.wholesales.dto.EntryUpdateDTO;
import com.kravchenko.wholesales.entity.Entry;

public interface EntryMapper {

    Entry toEntity(EntryCreateDTO dto);

    Entry toEntity(EntryUpdateDTO dto);

}
