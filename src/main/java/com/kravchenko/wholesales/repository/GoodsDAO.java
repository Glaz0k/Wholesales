package com.kravchenko.wholesales.repository;

import com.kravchenko.wholesales.constants.SortOrder;
import com.kravchenko.wholesales.model.Good;
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
public class GoodsDAO {

    private final NamedParameterJdbcTemplate template;

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

    public Good readGoodById(long id) {
        String sql = "SELECT * FROM goods " +
                "WHERE goods.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, parameterSource, new DataClassRowMapper<>(Good.class));
    }

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

    public void deleteGoodById(long id) {
        String sql = "DELETE FROM goods " +
                "WHERE goods.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        template.update(sql, parameterSource);
    }

    public List< Good > readAllGoodsFiltered(String sortColumn, SortOrder order) {
        String sql = SelectQuery.builder()
                .table("goods")
                .sortBy(sortColumn)
                .sortOrder(order)
                .build().toString();
        return template.query(sql, new DataClassRowMapper<>(Good.class));
    }
}
