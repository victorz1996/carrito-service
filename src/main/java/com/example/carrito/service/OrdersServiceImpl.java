package com.example.carrito.service;

import com.example.carrito.dto.OrdersDTO;
import com.example.carrito.entity.Orders;
import com.example.carrito.repository.OrdersRepository;
import com.example.carrito.service.mapper.OrdersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService{

    private final OrdersRepository ordersRepository;
    private final OrdersMapper ordersMapper;

    @Override
    public List<Orders> listAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders getOrder(Long id) {
        return ordersRepository.getOrder(id);
    }

    @Override
    public OrdersDTO createOrder(OrdersDTO orderDto) {
        Orders order = ordersMapper.toEntity(orderDto);
        order = ordersRepository.save(order);
        return ordersMapper.toDto(order);
    }
}
