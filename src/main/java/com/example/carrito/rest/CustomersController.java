package com.example.carrito.rest;

import com.example.carrito.entity.Customers;
import com.example.carrito.service.CustomersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/customers")
@RequiredArgsConstructor
public class CustomersController {
    private final CustomersService customersService;

    @GetMapping
    public ResponseEntity<List<Customers>> listCustomers(){
        List<Customers> customers;
        customers = customersService.listAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customers> getCustomer(@PathVariable("id") Long id){
        Customers customer = customersService.getCustomer(id);
        if(customer == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Customers> createCustomer(@RequestBody Customers customer) {
        Customers crearCustomer = customersService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(crearCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customers> updateCustomer(@PathVariable("id") Long id, @RequestBody Customers customer){
        customer.setCustomerID(id);
        Customers customerDB = customersService.updateCustomer(customer);
        if(customerDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerDB);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id){
        customersService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
