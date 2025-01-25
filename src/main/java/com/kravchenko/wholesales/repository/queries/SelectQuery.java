package com.kravchenko.wholesales.repository.queries;

import com.kravchenko.wholesales.constants.SortOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;

import java.util.Arrays;

@AllArgsConstructor
@Builder
public class SelectQuery {

    @NonNull
    private final String table;
    private final String[] columns;
    private final String sortBy;
    private final SortOrder sortOrder;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SELECT ");
        if (columns == null || columns.length == 0) {
            sb.append("*");
        } else {
            sb.append(columns[0]);
            Arrays.stream(columns, 1, columns.length)
                    .forEach(col -> {
                        sb.append(", ").append(col);
                    });
        }
        sb.append(" FROM ").append(table);
        if (sortBy == null) {
            return sb.toString();
        }
        sb.append(" ORDER BY ").append(sortBy);
        if (sortOrder != null) {
            sb.append(' ').append(sortOrder);
        }
        return sb.toString();
    }
}
