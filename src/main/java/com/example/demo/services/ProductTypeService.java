package com.example.demo.services;

import com.example.demo.exception.ProductTypeNotFound;
import com.example.demo.models.Product;
import com.example.demo.models.ProductType;
import com.example.demo.repositories.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeService {

    @Autowired
    ProductTypeRepository productTypeRepository;

    public List<ProductType> getAllProductType()
    {
        List<ProductType> productTypes = new ArrayList<ProductType>();
        productTypeRepository.findAll().forEach(productType -> productTypes.add(productType));
        return productTypes;
    }

    public ProductType getProductTypeById(int id)  {
        Optional<ProductType> productType= productTypeRepository.findById(id);
        if(productType.isPresent())
            return productType.get();
        return null;
    }

    public void saveOrUpdate(ProductType productType)
    {

        productTypeRepository.save(productType);
    }

    public ProductType delete(int id)
    {
        Optional<ProductType> productType= productTypeRepository.findById(id);
        if(productType.isPresent()){
            productTypeRepository.deleteById(id);
            return productType.get();
        }

        return null;

    }
    //updating a record
    public void update(ProductType productType, int id)
    {
        productTypeRepository.save(productType);
    }
}
