package com.kravchenko.wholesales.repository.impl;

import com.kravchenko.wholesales.enums.SortOrder;
import com.kravchenko.wholesales.model.Entry;
import com.kravchenko.wholesales.repository.IEntriesDAO;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class JdbcEntriesDAO implements IEntriesDAO {

    private final NamedParameterJdbcTemplate template;

    @Override
    public List< Entry > readWarehouseEntriesSorted(long warehouseId, String sortBy, SortOrder sortOrder) {
        String sql = "SELECT * FROM entries " +
            "WHERE entries.warehouse_id = :id" +
            "ORDER BY " + sortBy +
            " " + sortOrder.toString();
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", warehouseId);
        return template.query(sql, parameterSource, new DataClassRowMapper<>(Entry.class));
    }

    @Override
    public Entry createEntry(Entry entry) {
        String sql = "INSERT INTO entries (id, warehouse_id, good_id, good_count) " +
            "VALUES (:id, :warehouse_id, :good_id, :good_count)";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
            .addValue("id", entry.id())
            .addValue("warehouse_id", entry.warehouse_id())
            .addValue("good_id", entry.good_id())
            .addValue("good_count", entry.good_count());
        template.update(sql, parameterSource);
        return entry;
    }

    @Override
    public Entry readEntryById(long id) {
        String sql = "SELECT * FROM entries " +
            "WHERE entries.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, parameterSource, new DataClassRowMapper<>(Entry.class));
    }

    @Override
    public Entry updateEntry(Entry entry) {
        String sql = "UPDATE entries " +
            "SET warehouse_id = :warehouse_id, good_id = :good_id, good_count = :good_count " +
            "WHERE entries.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
            .addValue("id", entry.id())
            .addValue("warehouse_id", entry.warehouse_id())
            .addValue("good_id", entry.good_id())
            .addValue("good_count", entry.good_count());
        if (template.update(sql, parameterSource) == 0) {
            return createEntry(entry);
        }
        return entry;
    }

    @Override
    public void deleteEntryById(long id) {
        String sql = "DELETE FROM entries " +
            "WHERE entries.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        template.update(sql, parameterSource);
    }
}
