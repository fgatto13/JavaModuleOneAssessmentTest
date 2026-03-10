package com.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ECommerceTest {

    private Inventory inventory;
    private ShoppingCart cart;

    @BeforeEach
    @DisplayName("This method is executed before each test to fill the inventory with the same data")
    void setUp() {
        inventory = new Inventory();
        inventory.addProduct(new Product(1, "Laptop", 1200.00, 10));
        inventory.addProduct(new Product(2, "Mouse", 25.00, 30));
        inventory.addProduct(new Product(3, "Keyboard", 75.00, 20));

        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("1. Asserts that price of an Order is calculated correctly")
    void testCalculateTotalPriceOfOrder() {
        Product laptop = inventory.findProductById(1, false);
        cart.addProduct(laptop);
        Order order = new Order(1, cart.getItems());
        assertEquals(1200.00, order.getTotalPrice(), "Implement calculateTotalPrice in Order class.");
    }

    @Test
    @DisplayName("2. Asserts that inventory correctly returns the stock of an item")
    void testGetStockOfProduct() {
        assertEquals(20, inventory.getStock(3), "Implement getStock in Inventory class.");
    }

    @Test
    @DisplayName("3. Asserts that reducing stock quantity is effective on the inventory")
    void testReduceStockAfterOrder() {
        Product laptop = inventory.findProductById(1, false);
        cart.addProduct(laptop);
        new Order(1, cart.getItems());
        inventory.reduceStock(1, 1);
        assertEquals(9, inventory.getStock(1), "Implement reduceStock in Inventory class.");
    }

    @Test
    @DisplayName("4. Asserts that removing a product from the inventory, deletes it from the collection")
    void testRemoveProductFromInventory() {
        inventory.removeProduct(2);
        assertNull(inventory.findProductById(2, false), "Implement removeProduct in Inventory class.");
    }

    @Test
    @DisplayName("5. Asserts that removing a product from the shopping chart, deletes it from the collection")
    void testRemoveProductFromCart() {
        Product mouse = inventory.findProductById(2, false);
        cart.addProduct(mouse);
        cart.removeProduct(mouse);
        assertFalse(cart.getItems().contains(mouse), "Implement removeProduct in ShoppingCart class.");
    }

    @Test
    @DisplayName("6. Asserts that price of a shopping chart is calculated correctly")
    void testCalculateTotalPriceOfCart() {
        Product laptop = inventory.findProductById(1, false);
        Product mouse = inventory.findProductById(2, false);
        cart.addProduct(laptop);
        cart.addProduct(mouse);
        assertEquals(1225.00, cart.calculateTotal(), "Implement and fix calculateTotal in ShoppingCart class.");
    }

    @Test
    @DisplayName("7. Asserts that chart can be cleared of all items")
    void testClearCart() {
        Product keyboard = inventory.findProductById(3, false);
        cart.addProduct(keyboard);
        cart.clearCart();
        assertTrue(cart.getItems().isEmpty(), "Implement clearCart in ShoppingCart class.");
    }

    @Test
    @DisplayName("8. Asserts that initial status is PENDING")
    void testOrderStatusInitiallyPending() {
        Order order = new Order(2, new ArrayList<>());
        assertEquals(OrderStatus.PENDING, order.getStatus(), "Fix Order constructor to set initial status to PENDING.");
    }

    @Test
    @DisplayName("9. Asserts that status of an order can be changed")
    void testChangeOrderStatus() {
        Order order = new Order(3, new ArrayList<>());
        order.setStatus(OrderStatus.SHIPPED);
        assertEquals(OrderStatus.SHIPPED, order.getStatus(), "Fix setStatus in Order class.");
    }

    @Test
    @DisplayName("10. Asserts that deleting an item twice, throws an Exception")
    void testDeletionResilience() {
        inventory.removeProduct(2);
        assertNull(inventory.findProductById(2, false));

        assertThrows(ProductNotFoundException.class, () -> inventory.removeProduct(2));
    }

    @Test
    @DisplayName("X. Asserts that modification of copies have not effect on items in the inventory")
    void testFindProductById() {
        Product laptop = inventory.findProductById(1, true);
        laptop.setStockQuantity(5);
        assertEquals(10, inventory.findProductById(1, false).getStockQuantity(), "A hidden bug is present, find it and fix it");
    }
}
