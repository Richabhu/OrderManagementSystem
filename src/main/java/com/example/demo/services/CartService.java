package com.example.demo.services;

import com.example.demo.models.Cart;
import com.example.demo.models.Product;
import com.example.demo.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public List<Cart> getAllCart()
    {
        List<Cart> carts = new ArrayList<Cart>();
        cartRepository.findAll().forEach(cart -> carts.add(cart));
        return carts;
    }

    public Cart getCartById(int id)  {
        Optional<Cart> cart= cartRepository.findById(id);
        if(cart.isPresent())
            return cart.get();
        return null;
    }

    public Cart getCartByUserId(int userId)  {
        List<Cart> cartList = getAllCart();
        for(Cart cart: cartList){
            if(cart.getCustomerId() == userId && cart.getOrderId() == null)
                return cart;
        }
        return null;
    }

    public void saveOrUpdate(Cart cart)
    {

        cartRepository.save(cart);
    }

    public Cart delete(int id)
    {
        Optional<Cart> cart = cartRepository.findById(id);
        if(cart.isPresent()){
            cartRepository.deleteById(id);
            return cart.get();
        }

        return null;

    }
    //updating a record
    public Cart update(Cart cart)
    {
        int cartId = cart.getId();
        Cart fetchedCart = getCartById(cartId);
        if(fetchedCart == null || fetchedCart.getCustomerId() != cart.getCustomerId())
        {
            return null;
        }
        boolean products = fetchedCart.getProductList().addAll(cart.getProductList());
        Set<Product> productSet = new HashSet<>(fetchedCart.getProductList());
        fetchedCart.setProductList(new ArrayList<Product>(productSet));
        //todo: validate product ids
        cartRepository.save(fetchedCart);
        return fetchedCart;
    }
}