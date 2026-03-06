package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds a product to the shopping cart and reduces its stock in the inventory.
     *
     * @param product The product to add.
     */
    public void addProduct(Product product) {
        items.add(product);
    }

    /**
     * Removes a product from the shopping cart.
     *
     * @param product The product to remove.
     */
    public void removeProduct(Product product) {
        if (items.contains(product)) {
            items.remove(product);
        }
        else {
            System.err.println("Product not found in shopping cart.");
        }
    }

    public List<Product> getItems() {
        return items;
    }

    /**
     * Calculates the total price of all items in the shopping cart.
     *
     * @return The total price.
     */
    public double calculateTotal() {
        return items.isEmpty() ? 0.0 : items.stream().mapToDouble(Product::getPrice).sum();
    }

    /**
     * Clears all items from the shopping cart.
     */
    public void clearCart() {
        if (!items.isEmpty()) {
            items.clear();
        }
        else {
            System.err.println("Shopping cart is already empty.");
        }
    }
}
