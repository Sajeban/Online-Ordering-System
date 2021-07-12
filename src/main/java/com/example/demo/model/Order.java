package com.example.demo.model;

import com.example.demo.util.Status;

import java.util.List;

public class Order {
    int customerID;
    Status status;
    double totalPrice;
    String notes;
    List<Product> productList;

    public Order() {
    }

    public Order(int customerID, Status status, List<Product> productList) {
        this.customerID = customerID;
        this.status = status;
        this.productList = productList;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    @Override
    public String toString() {
        return "Order{" +
                "customerID=" + customerID +
                ", status=" + status +
                ", totalPrice=" + totalPrice +
                ", notes='" + notes + '\'' +
                ", productList=" + productList +
                '}';
    }

}
