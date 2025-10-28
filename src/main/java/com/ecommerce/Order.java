package com.ecommerce;

import java.util.List;

public class Order {
    private int orderId;
    private List<Product> products;
    private double totalPrice;
    private OrderStatus status;

    public Order(int orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
        this.totalPrice = calculateTotalPrice();
        // FIXME: The constructor should set the initial status to PENDING
    }

    /**
     * Calculates the total price of the order by summing the prices of all products in the order.
     *
     * @return The total price of the order.
     */
    private double calculateTotalPrice() {
        // FIXME: This method should return the total price, instead of returning zero
        return 0;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    /**
     * Sets the status of the order.
     *
     * @param status The new status of the order.
     */
    public void setStatus(OrderStatus status) {
        // TODO: implement this method
    }
}
