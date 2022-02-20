package com.example.demo.controllers;

import com.example.demo.exception.ProductTypeNotFound;
import com.example.demo.models.Product;
import com.example.demo.models.ProductType;
import com.example.demo.models.Vendor;
import com.example.demo.responses.ProductTypeResponse;
import com.example.demo.services.ProductService;
import com.example.demo.services.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    public ProductService productService;


    @GetMapping("")
    private List<Product> getAllProduct()
    {
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Product> getProduct(@PathVariable("id") int id)
    {

        Product product = productService.getProductById(id);
        if(product != null)
            return ResponseEntity.ok(product);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Product> deleteProduct(@PathVariable("id") int id)
    {
        Product product =  productService.delete(id);
        if(product != null)
            return ResponseEntity.ok(product);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PostMapping("")
    private ResponseEntity<Product> saveProduct(@RequestBody Product product) throws ProductTypeNotFound {

        Product productRes =   productService.saveOrUpdate(product);
        if(productRes != null)
            return ResponseEntity.ok(productRes);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PutMapping("")
    private ResponseEntity<Product> update(@RequestBody Product product) throws ProductTypeNotFound {

        Product productRes =   productService.saveOrUpdate(product);
        if(productRes != null)
            return ResponseEntity.ok(productRes);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }
}
