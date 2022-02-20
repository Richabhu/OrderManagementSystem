package com.example.demo.repositories;

import com.example.demo.models.Orders;
import com.example.demo.models.Product;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<Orders, Integer> {
}
