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
        Product productToRemove = findProductById(productId, false);
        if (productToRemove != null) {
            products.remove(productToRemove);
        } else {
            throw new ProductNotFoundException();
        }
    }

    /**
     * This function either returns a copy of the object, or the reference to it.
     * Therefore, it is up to the caller to specify wether it wants a copy of the object or the object itself.
     * 
     * @param productId is the id of the product we're looking for (int)
     * @param asksForCopy is a boolean to check wether the caller wants a copy or the reference
     * @return either an object (or its copy) or null
     */
    public Product findProductById(int productId, boolean asksForCopy) {
        for (Product product : products) {
            if (product.getId() == productId) {
                if (asksForCopy) {
                    return new Product(product.getId(), product.getName(), product.getPrice(), product.getStockQuantity());
                }
                else{
                    return product;
                }
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
        Product productToIncrement = findProductById(productId, false);
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
        Product product = findProductById(productId, false);
        if (product != null) {
            return product.getStockQuantity();
        }
        return -1;
    }
}
