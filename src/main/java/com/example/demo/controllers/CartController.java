package com.example.demo.controllers;

import com.example.demo.models.Cart;
import com.example.demo.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    public CartService cartService;


    @GetMapping("")
    private List<Cart> getAllCartDetails()
    {
        return cartService.getAllCart();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Cart> getCart(@PathVariable("id") int id)  {
        Cart cart = cartService.getCartById(id);
        if(cart != null)
            return ResponseEntity.ok(cart);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);


    }
    @GetMapping("/user/{id}")
    private ResponseEntity<Cart> getCartByUser(@PathVariable("id") int id)  {
        Cart cart = cartService.getCartByUserId(id);
        return ResponseEntity.ok(cart);



    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Cart> deleteCart(@PathVariable("id") int id)
    {
        Cart cart = cartService.delete(id);
        if(cart != null)
            return ResponseEntity.ok(cart);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PostMapping("")
    private Cart saveCart(@Validated @RequestBody Cart cart)
    {
        cartService.saveOrUpdate(cart);
        return cart;
    }

    @PutMapping("")
    private ResponseEntity<Cart> update(@Validated @RequestBody Cart cart)
            throws ConfigDataResourceNotFoundException
    {
        Cart cartRes = cartService.update(cart);
        if(cartRes!= null)
            return ResponseEntity.ok(cart);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
