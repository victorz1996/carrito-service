package com.example.carrito.service;

import com.example.carrito.entity.Customers;
import com.example.carrito.repository.CustomersRepository;
import com.example.carrito.service.mapper.CustomersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomersServiceImpl implements CustomersService{
    private final CustomersRepository customersRepository;
    private final CustomersMapper customersMapper;

    @Override
    public List<Customers> listAllCustomers() {
        return customersRepository.findAll();
    }

    @Override
    public Customers getCustomer(Long id) {
        return customersRepository.findById(id).orElse(null);
    }

    @Override
    public Customers createCustomer(Customers customer) {
        Customers customerDB = customersRepository.getCustomer(customer.getCustomerID());
        if( customerDB != null ) {
            return customerDB;
        }
        return customersRepository.save(customer);
    }

    @Override
    public Customers updateCustomer(Customers customer) {
        Customers customerDB = getCustomer(customer.getCustomerID());
        if (customerDB == null) {
            return null;
        }
        customerDB.setFirstName(customer.getFirstName());
        customerDB.setLastName(customer.getLastName());
        customerDB.setCountry(customer.getCountry());
        customerDB.setCity(customer.getCity());
        customerDB.setPostalCode(customer.getPostalCode());
        customerDB.setStreet(customer.getStreet());
        customerDB.setHouseNumber(customer.getHouseNumber());
        return customersRepository.save(customerDB);
    }

    @Override
    public void deleteCustomer(Long id) {
        customersRepository.deleteById(id);
    }
}
