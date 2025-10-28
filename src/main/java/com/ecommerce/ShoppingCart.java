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
        // TODO: Implement this method
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
        // FIXME: This method should calculate the total price of the items in the cart
        // There is a bug here, the total is always 0
        return 0.0;
    }

    /**
     * Clears all items from the shopping cart.
     */
    public void clearCart() {
        // TODO: Implement this method
    }
}
