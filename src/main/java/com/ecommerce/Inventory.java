package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Removes a product from the inventory by its ID.
     *
     * @param productId The ID of the product to remove.
     * @throws ProductNotFoundException if no product with the given id exists.
     */
    public void removeProduct(int productId) throws ProductNotFoundException {
        // TODO: Implement this method
    }

    public Product findProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    /**
     * Reduces the stock of a product by a specified quantity.
     *
     * @param productId The ID of the product.
     * @param quantity  The quantity to reduce the stock by.
     */
    public void reduceStock(int productId, int quantity) {
        // TODO: Implement this method
    }

    /**
     * Gets the current stock quantity of a product.
     *
     * @param productId The ID of the product.
     * @return The current stock quantity.
     */
    public int getStock(int productId) {
        // FIXME: This method should return the correct quantity
        return -1;
    }
}
