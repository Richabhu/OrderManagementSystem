package com.example.demo.services;

import com.example.demo.exception.ProductTypeNotFound;
import com.example.demo.exception.VendorNotFoundException;
import com.example.demo.models.Product;
import com.example.demo.models.ProductType;
import com.example.demo.models.Vendor;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    VendorService vendorService;

    @Autowired
    ProductTypeService productTypeService;

    public List<Product> getAllProduct()
    {
        List<Product> products = new ArrayList<Product>();
        productRepository.findAll().forEach(books1 -> products.add(books1));
        return products;
    }

    public Product getProductById(int id)
    {
        Optional<Product> product= productRepository.findById(id);
        if(product.isPresent())
            return product.get();
        return null;
    }

    public Product saveOrUpdate(Product product) throws ProductTypeNotFound {
        int vendorId = product.getVendorId();
        int productTypeId = product.getProductTypeId();

        Vendor vendor = vendorService.getVendorById(vendorId);
        if(vendor == null)
            return null;

        ProductType productType = productTypeService.getProductTypeById(productTypeId);
        if(productType == null)
            return null;

        product.setAvailable(true);
        productRepository.save(product);
        return product;
    }

    public Product delete(int id)
    {
        Optional<Product> product= productRepository.findById(id);
        if(product.isPresent()){
            productRepository.deleteById(id);
            return product.get();
        }
        return null;
    }
    //updating a record
    public void update(Product product, int id)
    {
        productRepository.save(product);
    }
}
