package com.example.carrito.rest;

import com.example.carrito.dto.OrdersDTO;
import com.example.carrito.entity.Orders;
import com.example.carrito.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService ordersService;

    @GetMapping
    public ResponseEntity<List<Orders>> listOrders(){
        List<Orders> orders;
        orders = ordersService.listAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrder(@PathVariable("id") Long id){
        Orders order = ordersService.getOrder(id);
        if(order == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<OrdersDTO> createOrder(@RequestBody OrdersDTO orderDto){
        OrdersDTO createOrder = ordersService.createOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createOrder);
    }
}
