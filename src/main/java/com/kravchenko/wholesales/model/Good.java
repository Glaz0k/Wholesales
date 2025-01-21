package com.kravchenko.wholesales.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.jdbc.core.RowMapper;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class Good {

    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Float priority;

    private static Map< String, Comparator< ? super Good > > sortProps;

    static {
        sortProps = new HashMap<>();
        sortProps.put("ID", Comparator.comparingLong(Good::getId));
        sortProps.put("NAME", Comparator.comparing(Good::getName));
        sortProps.put("PRIORITY", Comparator.comparingDouble(Good::getPriority));
    }

    public static Comparator< ? super Good > getComparator(String filter) {
        return sortProps.get(filter);
    }

    public static RowMapper< Good > getRowMapper() {
        return ((rs, rowNum) -> Good.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .priority(rs.getFloat("priority"))
                .build());
    }

}
