package com.example.carrito.service.mapper;


import com.example.carrito.dto.ProductsDTO;
import com.example.carrito.entity.Products;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProductsMapper extends EntityMapper<ProductsDTO, Products>{

    default Products fromProductID(Long id) {
        if (id == null) {
            return null;
        }
        Products product  = new Products();
        product.setProductID(id);
        return product;
    }
}
