package com.example.carrito.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class OrdersDTO implements Serializable {
    private Long orderID;
    private Long customerID;
    private Instant orderDate;
    private String orderLocation;
}
