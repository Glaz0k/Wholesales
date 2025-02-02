package com.kravchenko.wholesales.repository.impl;

import com.kravchenko.wholesales.enums.SortOrder;
import com.kravchenko.wholesales.model.Good;
import com.kravchenko.wholesales.repository.IGoodsDAO;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class JdbcGoodsDAO implements IGoodsDAO {

    private final NamedParameterJdbcTemplate template;

    @Override
    public Good createGood(Good good) {
        String sql = "INSERT INTO goods (id, name, priority)" +
            "VALUES (:id, :name, :priority)";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
            .addValue("id", good.id())
            .addValue("name", good.name())
            .addValue("priority", good.priority());
        template.update(sql, parameterSource);
        return good;
    }

    @Override
    public Good readGoodById(long id) {
        String sql = "SELECT * FROM goods " +
            "WHERE goods.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, parameterSource, new DataClassRowMapper<>(Good.class));
    }

    @Override
    public Good updateGood(Good good) {
        String sql = "UPDATE goods " +
            "SET name = :name, priority = :priority " +
            "WHERE goods.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
            .addValue("id", good.id())
            .addValue("name", good.name())
            .addValue("priority", good.priority());
        template.update(sql, parameterSource);
        return good;
    }

    @Override
    public void deleteGoodById(long id) {
        String sql = "DELETE FROM goods " +
            "WHERE goods.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        template.update(sql, parameterSource);
    }

    @Override
    public List< Good > readAllGoodsSorted(String sortCol, SortOrder sortOrder) {
        String sql = "SELECT * FROM goods " +
            "ORDER BY " + sortCol + " " + sortOrder.name();
        return template.query(sql, new DataClassRowMapper<>(Good.class));
    }
}
