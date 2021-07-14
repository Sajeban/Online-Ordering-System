package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Shipping;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ShippingRepository;
import com.example.demo.util.CustomerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ShippingRepository shippingRepository;

    public void createCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
        if (customerOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        customer.setCustomerStatus(CustomerStatus.ACTIVE);
        customerRepository.save(customer);
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getParticularCustomer(int id) {
        Optional<Customer> customerOptional = customerRepository.findCustomerById(id);
        return customerOptional.get();
    }

    public ResponseEntity<Map<String, String>> loginCustomer(String username, String password) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(username);
        if (customerOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "username not found or invalid email");
        }
        if (password.equals(customerOptional.get().getPassword())) {
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("X-Rate-Limit", "10");
            responseHeaders.set("X-Expires-After", "21:10:10");

            Map<String, String> map = new HashMap<>();
            map.put("status", "success");
            return new ResponseEntity<Map<String, String>>(map, responseHeaders, HttpStatus.OK);
//      return ResponseEntity.ok().headers(responseHeaders).body("Response with header using ResponseEntity");
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password Wrong");
        }

    }

    public ResponseEntity deleteCustomer(int id) {
        Optional<Customer> customerOptional = customerRepository.findCustomerById(id);
        if (customerOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
        }
        customerOptional.get().setCustomerStatus(CustomerStatus.INACTIVE);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    public void createShipping(Shipping shipping, int id) {
        Optional<Customer> customerOptional = customerRepository.findCustomerById(id);
        customerOptional.get().getShippings().add(shipping);
        shipping.setCustomer(customerOptional.get());
        shippingRepository.save(shipping);
        // customerRepository.save(customerOptional.get());
    }

    public List<Shipping> getShippingParticularCustomer(int id) {
        Optional<Customer> customerOptional = customerRepository.findCustomerById(id);
        return customerOptional.get().getShippings();
    }

    public Shipping getShipping(int shippingId) {
        Optional<Shipping> shippingOptional = shippingRepository.findShippingByShippingID(shippingId);
        return shippingOptional.get();
    }
}
