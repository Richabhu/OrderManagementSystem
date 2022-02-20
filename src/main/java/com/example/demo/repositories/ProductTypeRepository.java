package com.example.demo.repositories;

import com.example.demo.models.ProductType;
import org.springframework.data.repository.CrudRepository;

public interface ProductTypeRepository extends CrudRepository<ProductType, Integer> {
}

