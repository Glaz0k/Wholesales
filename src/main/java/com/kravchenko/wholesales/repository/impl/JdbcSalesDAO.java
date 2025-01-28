package com.kravchenko.wholesales.repository.impl;

import com.kravchenko.wholesales.enums.SortOrder;
import com.kravchenko.wholesales.model.Sale;
import com.kravchenko.wholesales.repository.ISalesDAO;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class JdbcSalesDAO implements ISalesDAO {

    private final NamedParameterJdbcTemplate template;

    @Override
    public Sale createSale(Sale sale) {
        String sql = "INSERT INTO sales (id, good_id, good_count, create_date)" +
                "VALUES (:id, :good_id, :good_count, :create_date)";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", sale.id())
                .addValue("good_id", sale.good_id())
                .addValue("good_count", sale.good_count())
                .addValue("create_date", sale.create_date());
        template.update(sql, parameterSource);
        return sale;
    }

    @Override
    public Sale readSaleById(long id) {
        String sql = "SELECT * FROM sales " +
                "WHERE salas.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, parameterSource, new DataClassRowMapper<>(Sale.class));
    }

    @Override
    public Sale updateSale(Sale sale) {
        String sql = "UPDATE sales " +
                "SET good_id = :good_id, good_count = :good_count, create_date = :create_date " +
                "WHERE sales.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", sale.id())
                .addValue("good_id", sale.good_id())
                .addValue("good_count", sale.good_count())
                .addValue("create_date", sale.create_date());
        template.update(sql, parameterSource);
        return sale;
    }

    @Override
    public void deleteSaleById(long id) {
        String sql = "DELETE FROM sales " +
                "WHERE sales.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        template.update(sql, parameterSource);
    }

    @Override
    public List< Sale > readAllSalesSorted(String sortCol, SortOrder sortOrder) {
        String sql = "SELECT * FROM sales " +
                "ORDER BY " + sortCol + " " + sortOrder.toString();
        return template.query(sql, new DataClassRowMapper<>(Sale.class));
    }
}
