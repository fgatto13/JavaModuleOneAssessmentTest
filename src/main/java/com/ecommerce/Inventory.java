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
        Product productToRemove = findProductById(productId);
        if (productToRemove != null) {
            products.remove(productToRemove);
        } else {
            throw new ProductNotFoundException();
        }
    }

    public Product findProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                // since we only want to find the product, we need to avoid passing it directly, 
                // otherwise any unallowed mod to that object would be reflected in the corresponding product in the Inventory.
                // Because of that, we need to return a COPY of the actual item, not the item itself.
                return new Product(product.getId(), product.getName(), product.getPrice(), product.getStockQuantity());
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
        // first of all, we need to find the prouduct in the inventory. 
        // Since Java passes the reference of the object, we can directly modify the variable, w/o needing to manually updating the collection.
        Product productToIncrement = findProductById(productId);
        // we want to check that the product exists before we move on
        try{
            if (productToIncrement != null) {
                int currentStock = productToIncrement.getStockQuantity();
                // we first want to check if the current stock is greater than, or equal to the quantity to increment
                if(currentStock >= quantity) {
                    productToIncrement.setStockQuantity(currentStock - quantity);
                }
                else {
                    throw new IllegalArgumentException("Not enough stock for product ID " + productId);
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Gets the current stock quantity of a product.
     *
     * @param productId The ID of the product.
     * @return The current stock quantity.
     */
    public int getStock(int productId) {
        Product product = findProductById(productId);
        if (product != null) {
            return product.getStockQuantity();
        }
        return -1;
    }
}
