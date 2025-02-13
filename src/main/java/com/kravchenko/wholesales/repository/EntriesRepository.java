package com.kravchenko.wholesales.repository;

import com.kravchenko.wholesales.entity.Entry;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntriesRepository extends CrudRepository< Entry, Long > {

    @Query("SELECT * FROM entries WHERE warehouse_id = :warehouseId")
    List< Entry > findByWarehouseId(Long warehouseId);

}
