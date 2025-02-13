package com.kravchenko.wholesales.repository;

import com.kravchenko.wholesales.entity.Good;
import org.springframework.data.repository.CrudRepository;

public interface GoodsRepository extends CrudRepository< Good, Long > {

}
