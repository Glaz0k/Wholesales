package com.kravchenko.wholesales.entity;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("warehouses")
@AllArgsConstructor
public class Warehouse {

    @Id
    @Min(0)
    @Column("id")
    private Long id;
}
