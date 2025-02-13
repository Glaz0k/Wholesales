package com.kravchenko.wholesales.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("goods")
@AllArgsConstructor
public class Good {

    @Id
    @Min(0)
    @Column("id")
    private Long id;

    @NotBlank
    @Column("name")
    private String name;

    @Column("priority")
    private Float priority;
}
