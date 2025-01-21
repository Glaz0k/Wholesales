package com.kravchenko.wholesales.repository;

import com.kravchenko.wholesales.model.Good;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class GoodsDAO {

    private final NamedParameterJdbcTemplate template;

    public Long createGood(Good good) {
        String sql = "INSERT INTO goods (id, name, priority)" +
                "VALUES (:id, :name, :priority)" +
                "RETURNING ID";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", good.getId())
                .addValue("name", good.getName())
                .addValue("priority", good.getPriority());
        return template.queryForObject(sql, parameterSource, Long.class);
    }

    public Good readGoodById(long id) {
        String sql = "SELECT * FROM goods " +
                "WHERE goods.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, parameterSource, (rs, rowNum) -> Good.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .priority(rs.getFloat("priority"))
                .build()
        );
    }

    public void updateGood(Good good) {
        String sql = "UPDATE goods " +
                "SET name = :name, priority = :priority " +
                "WHERE goods.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", good.getId())
                .addValue("name", good.getName())
                .addValue("priority", good.getPriority());
        template.update(sql, parameterSource);
    }

    public void deleteGoodById(long id) {
        String sql = "DELETE FROM goods " +
                "WHERE goods.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        template.update(sql, parameterSource);
    }
}
