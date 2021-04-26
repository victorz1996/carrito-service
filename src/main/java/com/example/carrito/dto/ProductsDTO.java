package com.example.carrito.dto;

import lombok.Data;

@Data
public class ProductsDTO {
    private Long productID;
    private String description;
    private Boolean available;
    private Double purchasePrice;
    private Double sellingPrice;
    private Double weight;
    private String storageLocation;
}
