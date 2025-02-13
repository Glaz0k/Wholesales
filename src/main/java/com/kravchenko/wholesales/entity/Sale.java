package com.kravchenko.wholesales.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Data
@Table("sales")
@AllArgsConstructor
public class Sale {

    @Id
    @Min(0)
    @Column("id")
    private Long id;

    @NotBlank
    @Column("good_id")
    private AggregateReference< Good, Long > good;

    @Min(1)
    @NotBlank
    @Column("good_count")
    private Long goodCount;

    @Column("create_date")
    private Timestamp createDate;

}
