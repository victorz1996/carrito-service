package com.example.carrito.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Orderline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordelineID;
    @ManyToOne
    @JoinColumn(name = "orderid")
    private Orders orderID;
    @ManyToOne
    @JoinColumn(name = "productid")
    private Products productID;
    private Double quantity;
}
