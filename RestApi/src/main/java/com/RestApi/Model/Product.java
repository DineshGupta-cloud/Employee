package com.RestApi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
        name = "products",
        schema = "ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique",
                        columnNames = "stock_keeping_unit"
                )
        }
)
public class Product {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_generator"
    )

    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence_name",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;

    @Column(nullable = false)
    private String name;

    private String description;
    private BigDecimal price;
    private boolean active;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}