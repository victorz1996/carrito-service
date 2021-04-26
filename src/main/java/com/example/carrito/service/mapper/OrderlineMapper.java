package com.example.carrito.service.mapper;

import com.example.carrito.dto.OrderlineDTO;
import com.example.carrito.entity.Orderline;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductsMapper.class, OrdersMapper.class})
public interface OrderlineMapper extends EntityMapper<OrderlineDTO, Orderline>{

    @Mapping(source = "orderID.orderID", target = "orderID")
    @Mapping(source = "productID.productID", target = "productID")
    OrderlineDTO toDto(Orderline orderline);

    @Mapping(source = "orderID", target = "orderID")
    @Mapping(source = "productID", target = "productID")
    Orderline toEntity(OrderlineDTO orderlineDTO);

    default Orderline fromOrderlineID(Long id) {
        if (id == null) {
            return null;
        }
        Orderline orderline  = new Orderline();
        orderline.setOrdelineID(id);
        return orderline;
    }
}
