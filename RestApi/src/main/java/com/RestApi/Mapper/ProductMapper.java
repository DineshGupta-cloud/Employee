package com.RestApi.Mapper;

import com.RestApi.DTO.ProductDto;
import com.RestApi.Model.Product;

public class ProductMapper {

    // Convert Product JPA Entity into ProductDto
    public static ProductDto mapToProductDto(Product product) {
        ProductDto productDto = new ProductDto(
                product.getSku(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
//                product.getDateCreated(),
//                product.isActive(),
//                product.getLastUpdated()
        );
        return productDto;
    }

    // Convert UserDto into User JPA Entity
//    public static Product mapToUser(ProductDto productDto) {
//        Product product = new Product(
//                productDto.g(),
//                productDto.getFirstName(),
//                productDto.getLastName(),
//                productDto.getEmail()
//        );
//        return user;
//    }
}
