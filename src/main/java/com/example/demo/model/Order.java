package com.example.demo.model;

import com.example.demo.util.DeliveryStatus;

import java.util.List;

public class Order {
    int customerID;
    DeliveryStatus deliveryStatus;
    double totalPrice;
    String notes;
    List<Product> productList;

    public Order() {
    }

    public Order(int customerID, DeliveryStatus deliveryStatus, List<Product> productList) {
        this.customerID = customerID;
        this.deliveryStatus = deliveryStatus;
        this.productList = productList;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public DeliveryStatus getStatus() {
        return deliveryStatus;
    }

    public void setStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
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
                ", status=" + deliveryStatus +
                ", totalPrice=" + totalPrice +
                ", notes='" + notes + '\'' +
                ", productList=" + productList +
                '}';
    }

}
