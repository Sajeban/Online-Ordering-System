package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }

    @GetMapping(path = "{orderID}")
    public Product getOrderDetails(@PathVariable("orderID") int id) {
        return orderService.getOrderDetails(id);
    }

    @PatchMapping(path = "{orderID}")
    public void updateOrder(@PathVariable("orderID") int orderID) {
        orderService.updateOrder(orderID);
    }

    @GetMapping(path = "{customerID}/pastOrders")
    public Product getPastOrder(@PathVariable("customerID") int id) {
        return orderService.getPastOrders();
    }



}
