package com.kravchenko.wholesales.repository.impl;

import com.kravchenko.wholesales.enums.SortOrder;
import com.kravchenko.wholesales.model.Warehouse;
import com.kravchenko.wholesales.repository.IWarehousesDAO;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class JdbcWarehousesDAO implements IWarehousesDAO {

    private final NamedParameterJdbcTemplate template;

    @Override
    public Warehouse createWarehouse(Warehouse warehouse) {
        String sql = "INSERT INTO warehouses (id) " +
                "VALUES (:id)";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", warehouse.id());
        template.update(sql, parameterSource);
        return warehouse;
    }

    @Override
    public Warehouse readWarehouseById(long id) {
        String sql = "SELECT * FROM warehouses " +
                "WHERE warehouses.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, parameterSource, new DataClassRowMapper<>(Warehouse.class));
    }

    @Override
    public Warehouse updateWarehouse(Warehouse warehouse) {
        String sql = "UPDATE warehouses " +
                "WHERE warehouses.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", warehouse.id());
        if (template.update(sql, parameterSource) == 0) {
            return createWarehouse(warehouse);
        }
        return warehouse;
    }

    @Override
    public void deleteWarehouseById(long id) {
        String sql = "DELETE FROM warehouses " +
                "WHERE warehouses.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        template.update(sql, parameterSource);
    }

    @Override
    public List< Warehouse > readAllWarehousesSorted(String sortCol, SortOrder sortOrder) {
        String sql = "SELECT * FROM warehouses " +
                "ORDER BY " + sortCol +
                ' ' + sortOrder.toString();
        return template.query(sql, new DataClassRowMapper<>(Warehouse.class));
    }

}
