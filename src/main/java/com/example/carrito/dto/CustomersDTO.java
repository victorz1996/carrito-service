package com.example.carrito.dto;


import lombok.Data;


@Data
public class CustomersDTO {
    private Long customerID;
    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private String postalCode;
    private String street;
    private String houseNumber;
}
