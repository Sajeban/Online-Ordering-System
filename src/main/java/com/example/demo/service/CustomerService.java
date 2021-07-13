package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public void createCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
        if (customerOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        customerRepository.save(customer);
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getParticularCustomer(int id) {
        Optional<Customer> customerOptional = customerRepository.findCustomerById(id);
        return customerOptional.get();
    }

    public void loginCustomer(String username, String password) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(username);
        if (customerOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "username not found or invalid email");
        }
        if (password.equals(customerOptional.get().getPassword())) {
            System.out.println("Success");
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Password Wrong");
        }

    }
}
