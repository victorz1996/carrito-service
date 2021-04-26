package com.example.carrito.service;

import com.example.carrito.dto.OrderlineDTO;
import com.example.carrito.entity.Orderline;
import com.example.carrito.repository.OrderlineRepository;
import com.example.carrito.service.mapper.OrderlineMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderlineServiceImpl implements OrderlineService{

    private final OrderlineRepository orderlineRepository;
    private final OrderlineMapper orderlineMapper;

    @Override
    public OrderlineDTO createOrderline(OrderlineDTO orderlineDTO) {
        Orderline orderline = orderlineMapper.toEntity(orderlineDTO);
        orderline = orderlineRepository.save(orderline);
        return orderlineMapper.toDto(orderline);
    }
}
