package com.example.carrito.service.mapper;

import com.example.carrito.dto.OrdersDTO;
import com.example.carrito.entity.Orders;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {CustomersMapper.class})
public interface OrdersMapper extends EntityMapper<OrdersDTO, Orders>{

    @Mapping(source = "customerID.customerID", target = "customerID")
    OrdersDTO toDto(Orders order);

    @Mapping(source = "customerID", target = "customerID")
    Orders toEntity(OrdersDTO ordersDTO);

    default Orders fromOrderID(Long id) {
        if (id == null) {
            return null;
        }
        Orders order  = new Orders();
        order.setOrderID(id);
        return order;
    }
}
