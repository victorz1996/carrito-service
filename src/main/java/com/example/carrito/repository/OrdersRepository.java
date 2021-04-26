package com.example.carrito.repository;

import com.example.carrito.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query("select o from Orders o where o.orderID= :id")
    Orders getOrder(@Param("id") Long id);
}
