package com.example.carrito.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerID;
    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private String postalCode;
    private String street;
    private String houseNumber;
}
