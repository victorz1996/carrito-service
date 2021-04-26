package com.example.carrito.repository;

import com.example.carrito.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    public Products findByProductID(Long id);
}
