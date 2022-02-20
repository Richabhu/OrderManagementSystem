package com.example.demo.services;

import com.example.demo.enums.OrderStatus;
import com.example.demo.models.Cart;
import com.example.demo.models.Orders;
import com.example.demo.models.Product;
import com.example.demo.repositories.CartRepository;
import com.example.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartService cartService;

    public List<Orders> getAllOrders()
    {
        List<Orders> orders = new ArrayList<Orders>();
        orderRepository.findAll().forEach(order -> orders.add(order));
        return orders;
    }

    public Orders getOrderById(int id)  {
        Optional<Orders> order= orderRepository.findById(id);
        if(order.isPresent())
            return order.get();
        return null;
    }

    public List<Orders> getOrderByUserId(int userId)  {
        List<Orders> ordersList = getAllOrders();

        List<Orders> placedOrder= new ArrayList<>();
        for(Orders orders: ordersList){
            if(orders.getCustomerId() == userId)
                placedOrder.add(orders);
        }
        return placedOrder;
    }

    public void placeOrder(Orders order)
    {
        order.setOrderStatus(OrderStatus.BOOKED);
        int cartId = order.getCart().getId();
        Cart cart = cartService.getCartById(cartId);
        order = orderRepository.save(order);
        if(cart!= null)
            cart.setOrderId(order.getId());
            // todo: update in db



    }

    //updating a record
    public Orders update(Orders orders)
    {
        orderRepository.save(orders);
        return orders;
    }
}
