package com.ecommerce.ecommercebackend.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String imageUrl;
    private String category;
}