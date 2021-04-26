package com.example.carrito.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;
    @NotEmpty(message = "el campo description no debe ser nulo")
    private String description;
    private Boolean available;
    private Double purchasePrice;
    private Double sellingPrice;
    private Double weight;
    @NotEmpty(message = "el campo storageLocation no debe ser nulo")
    private String storageLocation;

}
