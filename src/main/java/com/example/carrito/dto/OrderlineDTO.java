package com.example.carrito.dto;

import lombok.Data;

@Data
public class OrderlineDTO {
    private Long ordelineID;
    private Long orderID;
    private Long productID;
    private Double quantity;
}
