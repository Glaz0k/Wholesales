package com.kravchenko.wholesales.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class Sale {

    private static Map< String, Comparator< ? super Sale > > sortProps;

    static {
        sortProps = new HashMap<>();
        sortProps.put("ID", Comparator.comparingLong(Sale::getId));
        sortProps.put("GOOD_ID", Comparator.comparing(Sale::getGood_id));
        sortProps.put("GOOD_COUNT", Comparator.comparingLong(Sale::getGood_count));
        sortProps.put("CREATE_DATE", Comparator.comparing(Sale::getCreate_date));
    }

    @NonNull
    private Long id;
    @NonNull
    private Long good_id;
    @NonNull
    private Long good_count;
    @NonNull
    private Timestamp create_date;

    public static Comparator< ? super Sale > getComparator(String fieldName) {
        return sortProps.get(fieldName.toUpperCase());
    }

    public static RowMapper< Sale > getRowMapper() {
        return ((rs, rowNum) -> Sale.builder()
                .id(rs.getLong("id"))
                .good_id(rs.getLong("good_id"))
                .good_count(rs.getLong("good_count"))
                .create_date(rs.getTimestamp("create_date"))
                .build());
    }
}
