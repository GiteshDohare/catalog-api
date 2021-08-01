package com.omnirio.catalog.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "products", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "category_id",
                "attribute_id"
        })
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "attribute_id", nullable = false)
    private Attribute attribute;
}
