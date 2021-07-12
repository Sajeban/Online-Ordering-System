package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public Product getProducts() {
        return new Product(1, "Chocolate");
    }

    public void createOrder(Order order) {
        System.out.println(order);
    }

    public Product getPastOrders() {
        return null;
    }

    public void updateOrder(int orderID) {
        System.out.println("Updating order");
    }

    public Product getOrderDetails(int id) {
        System.out.println("Done");
        return null;
    }
}