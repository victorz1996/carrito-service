package com.example.carrito.repository;

import com.example.carrito.entity.Orderline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderlineRepository extends JpaRepository<Orderline, Long> {
}
