package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping (path = "{customer_id}")
    public Customer getParticularCustomer(@PathVariable("customer_id") int id) {
        return customerService.getParticularCustomer(id);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Map<String, String>> loginCustomer(@RequestBody Map<String,String> json) {
        return customerService.loginCustomer(json.get("username"),json.get("password"));
    }
    @DeleteMapping(path = "{customer_id}")
    public ResponseEntity deleteCustomer(@PathVariable("customer_id") int id){
        return customerService.deleteCustomer(id);
    }

}
