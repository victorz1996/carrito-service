package com.example.carrito.service;

import com.example.carrito.entity.Products;

import java.io.IOException;
import java.util.List;

public interface ProductsService {
    public List<Products> listAllProducts();
    public Products getProduct(Long id);
    public Products createProduct(Products product);
    public Products updateProduct(Products product);
    public void deleteProduct(Long id);
    public String upFile(String name) throws IOException;
}
