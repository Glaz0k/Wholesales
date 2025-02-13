package com.kravchenko.wholesales.repository;

import com.kravchenko.wholesales.entity.Sale;
import org.springframework.data.repository.CrudRepository;

public interface SalesRepository extends CrudRepository< Sale, Long > {

}
