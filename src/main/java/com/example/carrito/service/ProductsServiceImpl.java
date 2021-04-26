package com.example.carrito.service;

import com.example.carrito.entity.Products;
import com.example.carrito.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService{

    private final ProductsRepository productsRepository;
    @Override
    public List<Products> listAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Products getProduct(Long id) {
        return productsRepository.findById(id).orElse(null);
    }

    @Override
    public Products createProduct(Products product) {
        Products productDB = productsRepository.findByProductID(product.getProductID());
        if( productDB != null ) {
            return productDB;
        }
        return productsRepository.save(product) ;
    }

    @Override
    public Products updateProduct(Products product) {
        Products productDB = getProduct(product.getProductID());
        if (productDB == null) {
            return null;
        }
        productDB.setAvailable(product.getAvailable());
        productDB.setDescription(product.getDescription());
        productDB.setPurchasePrice(product.getPurchasePrice());
        productDB.setSellingPrice(product.getSellingPrice());
        productDB.setWeight(product.getWeight());
        productDB.setStorageLocation(product.getStorageLocation());

        return productsRepository.save(productDB);
    }

    @Override
    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }

    @Override
    @Transactional
    public String upFile(String name) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("/home/interedes-068/carrito/src/main/resources/static/" + name));
        String line;
        try {
            while ((line = reader.readLine()) != null){
                Products product = new Products();
                String[] data = line.split(",");
                product.setDescription(data[0]);
                product.setAvailable(Boolean.parseBoolean(data[1]));
                product.setPurchasePrice(Double.parseDouble(data[2]));
                product.setSellingPrice(Double.parseDouble(data[3]));
                product.setWeight(Double.parseDouble(data[4]));
                product.setStorageLocation(data[5]);
                createProduct(product);
            }
            reader.close();
        }catch (Exception e){
            return null;
        }
        return "Informacion procesada";
    }
}
