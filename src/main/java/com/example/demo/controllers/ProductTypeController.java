package com.example.demo.controllers;

import com.example.demo.models.ProductType;
import com.example.demo.responses.ProductTypeResponse;
import com.example.demo.services.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product/type")
class ProductTypeController  {

    @Autowired
    public ProductTypeService productTypeService;


    protected ProductTypeResponse createResponse(List<ProductType> list) {
        ProductTypeResponse response = new ProductTypeResponse();
        response.setProductTypeList(list);
        return response;
    }


    @GetMapping("")
    private List<ProductType> getAllProductTypes()
    {
        return productTypeService.getAllProductType();
    }

    @GetMapping("/{id}")
    private ResponseEntity<ProductType> getProductType(@PathVariable("id") int id)  {
        ProductType productType = productTypeService.getProductTypeById(id);
        if(productType != null)
            return ResponseEntity.ok(productType);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);


    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ProductType> deleteProductType(@PathVariable("id") int id)
    {
        ProductType productType = productTypeService.delete(id);
        if(productType != null)
            return ResponseEntity.ok(productType);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PostMapping("")
    private ProductType saveProductType(@Validated  @RequestBody ProductType productType)
    {
        productTypeService.saveOrUpdate(productType);
        return productType;
    }

    @PutMapping("")
    private ProductType update(@Validated @RequestBody ProductType productType)
            throws ConfigDataResourceNotFoundException
    {
        productTypeService.saveOrUpdate(productType);
        return productType;
    }


}