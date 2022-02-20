package com.example.demo.controllers;

import com.example.demo.models.Cart;
import com.example.demo.models.Orders;
import com.example.demo.services.CartService;
import com.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    public OrderService orderService;


    @GetMapping("")
    private List<Orders> getAllCartOrders()
    {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Orders> getOrder(@PathVariable("id") int id)  {
        Orders order = orderService.getOrderById(id);
        if(order != null)
            return ResponseEntity.ok(order);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }

    @GetMapping("/user/{id}")
    private ResponseEntity<List<Orders>> getOrdersByUser(@PathVariable("id") int id)  {
        List<Orders> order = orderService.getOrderByUserId(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping("")
    private Orders saveOrder(@Validated @RequestBody Orders order)
    {
        orderService.placeOrder(order);
        return order;
    }

    @PutMapping("")
    private ResponseEntity<Orders> update(@Validated @RequestBody Orders order)
            throws ConfigDataResourceNotFoundException
    {
        Orders orders = orderService.update(order);
        if(orders!= null)
            return ResponseEntity.ok(orders);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
