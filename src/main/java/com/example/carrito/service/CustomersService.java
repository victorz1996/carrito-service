package com.example.carrito.service;

import com.example.carrito.entity.Customers;

import java.util.List;

public interface CustomersService {
    public List<Customers> listAllCustomers();
    public Customers getCustomer(Long id);
    public Customers createCustomer(Customers customer);
    public Customers updateCustomer(Customers customer);
    public void deleteCustomer(Long id);
}
