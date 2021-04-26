package com.example.carrito.service.mapper;

import com.example.carrito.dto.CustomersDTO;
import com.example.carrito.entity.Customers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CustomersMapper extends EntityMapper<CustomersDTO, Customers>{

    default Customers fromCustomerID(Long id) {
        if (id == null) {
            return null;
        }
        Customers customer  = new Customers();
        customer.setCustomerID(id);
        return customer;
    }
}
