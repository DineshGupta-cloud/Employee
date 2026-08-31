package com.RestApi.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

//    private Long id;
    private String sku;
    private String name;
    private String description;
    private BigDecimal price;
//    private boolean active;
//    private LocalDateTime dateCreated;
//    private LocalDateTime lastUpdated;
}
