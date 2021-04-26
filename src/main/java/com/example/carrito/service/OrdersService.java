package com.example.carrito.service;

import com.example.carrito.dto.OrdersDTO;
import com.example.carrito.entity.Orders;

import java.util.List;

public interface OrdersService {
    public List<Orders> listAllOrders();
    public Orders getOrder(Long id);
    public OrdersDTO createOrder(OrdersDTO orderDto);
}
