package com.example.demo.repository;

import com.example.demo.model.Customer;
import com.example.demo.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
    Optional<Shipping> findShippingByShippingID(int shippingID);
}
