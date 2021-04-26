package com.example.carrito;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CarritoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarritoApplication.class, args);
    }
}
