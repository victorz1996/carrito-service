package com.example.carrito.rest;

import com.example.carrito.entity.Products;
import com.example.carrito.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductsController {
    private final ProductsService productsService;

    @GetMapping
    public ResponseEntity<List<Products>> listProducts() {
        List<Products> products;
        products = productsService.listAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProduct(@PathVariable("id") Long id){
        Products product = productsService.getProduct(id);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Products> createProduct(@Valid @RequestBody Products product, BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, result.getAllErrors().toString());
        }
        Products crearProducto = productsService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(crearProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable("id") Long id, @RequestBody Products product){
        product.setProductID(id);
        Products productDB = productsService.updateProduct(product);
        if(productDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productsService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/upFiles/{name}")
    public ResponseEntity<String> upTxtFile(@PathVariable("name") String name) throws IOException {
        String result = productsService.upFile(name);
        if (result== null) {
            return ResponseEntity.ok().body("Hubo un error al cargar el archivo");
        }
        return ResponseEntity.ok().body(result);
    }


}
