package com.kravchenko.wholesales.repository;

import com.kravchenko.wholesales.model.Sale;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
@AllArgsConstructor
public class SalesDAO {

    private final NamedParameterJdbcTemplate template;

    public Long createSale(Sale sale) {
        String sql = "INSERT INTO sales (id, good_id, good_count, create_date)" +
                "VALUES (:id, :good_id, :good_count, :create_date)" +
                "RETURNING id";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", sale.getId())
                .addValue("good_id", sale.getGood_id())
                .addValue("good_count", sale.getGood_count())
                .addValue("create_date", sale.getCreate_date());
        return template.queryForObject(sql, parameterSource, Long.class);
    }

    public Sale readSaleById(long id) {
        String sql = "SELECT * FROM sales " +
                "WHERE salas.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, parameterSource, Sale.getRowMapper());
    }

    public void updateSale(Sale sale) {
        String sql = "UPDATE sales " +
                "SET good_id = :good_id, good_count = :good_count, create_date = :create_date " +
                "WHERE sales.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", sale.getId())
                .addValue("good_id", sale.getGood_id())
                .addValue("good_count", sale.getGood_count())
                .addValue("create_date", sale.getCreate_date());
        template.update(sql, parameterSource);
    }

    public void deleteSaleById(long id) {
        String sql = "DELETE FROM sales " +
                "WHERE sales.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        template.update(sql, parameterSource);
    }

    public List< Sale > readSaleByFilter(Comparator< ? super Sale > cmp) {
        String sql = "SELECT * FROM sales";
        return template.query(sql, Sale.getRowMapper());
    }
}
