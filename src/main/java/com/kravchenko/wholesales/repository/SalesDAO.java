package com.kravchenko.wholesales.repository;

import com.kravchenko.wholesales.constants.SortOrder;
import com.kravchenko.wholesales.model.Sale;
import com.kravchenko.wholesales.repository.queries.SelectQuery;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class SalesDAO {

    private final NamedParameterJdbcTemplate template;

    public Sale createSale(Sale sale) {
        String sql = "INSERT INTO sales (id, good_id, good_count, create_date)" +
                "VALUES (:id, :good_id, :good_count, :create_date)" +
                "RETURNING id";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", sale.id())
                .addValue("good_id", sale.good_id())
                .addValue("good_count", sale.good_count())
                .addValue("create_date", sale.create_date());
        template.update(sql, parameterSource);
        return sale;
    }

    public Sale readSaleById(long id) {
        String sql = "SELECT * FROM sales " +
                "WHERE salas.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, parameterSource, new DataClassRowMapper<>(Sale.class));
    }

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

    public void deleteSaleById(long id) {
        String sql = "DELETE FROM sales " +
                "WHERE sales.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        template.update(sql, parameterSource);
    }

    public List< Sale > readSaleByFilter(String sortColumn, SortOrder order) {
        String sql = SelectQuery.builder()
                .table("sales")
                .sortBy(sortColumn)
                .sortOrder(order)
                .build().toString();
        return template.query(sql, new DataClassRowMapper<>(Sale.class));
    }
}
