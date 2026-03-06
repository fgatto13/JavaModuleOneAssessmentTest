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
        this.status = OrderStatus.PENDING;
        this.totalPrice = calculateTotalPrice();
    }

    /**
     * Calculates the total price of the order by summing the prices of all products in the order.
     *
     * @return The total price of the order.
     */
    private double calculateTotalPrice() {
        if (products != null) 
            return products.stream().mapToDouble(Product::getPrice).sum();
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
        // We first want to check that the new status is valid, i.e. that it is within the allowed statuses.
        try {
            OrderStatus.valueOf(status.name());
            this.status = status;
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid order status: " + status);
        }
    }
}
