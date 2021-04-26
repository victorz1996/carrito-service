package com.example.carrito.rest;

import com.example.carrito.dto.OrderlineDTO;
import com.example.carrito.service.OrderlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orderlines")
public class OrderlineController {
    private final OrderlineService orderlineService;

    @PostMapping
    public ResponseEntity<OrderlineDTO> createOrderline(@RequestBody OrderlineDTO orderlineDTO){
        OrderlineDTO orderlineDB = orderlineService.createOrderline(orderlineDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderlineDB);
    }
}
