package com.example.carrito.repository;

import com.example.carrito.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
    @Query("select c from Customers c where c.customerID = :id")
    public Customers getCustomer(Long id);
}
