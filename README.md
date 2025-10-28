# Java Final Assessment — E-Commerce Challenge

## 🚀 Project Overview

Welcome to your final Java assessment! This project simulates a simple e-commerce order processing system. You'll be working with products, a shopping cart, orders, and inventory. Your mission, should you choose to accept it, is to complete the implementation, squash some bugs, and get the system running smoothly.

## 📂 Project Structure

The project is organized as a standard Maven project. Here's a map of the key files:

-   `src/main/java`: The home of the main application source code, neatly organized in the `com.ecommerce` package.
-   `src/test/java`: Where the JUnit tests for the application live.
-   `pom.xml`: The Maven project configuration file, containing all the necessary dependencies.

### Key Files

-   `Product.java`: Represents a product with an ID, name, price, and stock quantity.
-   `ShoppingCart.java`: Represents a shopping cart that holds a collection of products.
-   `Order.java`: Represents a customer's order.
-   `Inventory.java`: Manages the product inventory.
-   `ECommerceTest.java`: Contains 10 JUnit tests to verify the correctness of your implementation.

## 🎯 Your Mission

Your primary objective is to make all 10 JUnit tests in `ECommerceTest.java` pass. To achieve this, you will need to:

1.  **Implement the methods** marked with `// TODO`. Each of these methods has a Javadoc comment that explains what the method should do.
2.  **Fix the bugs** in the code marked with `// FIXME`. These are parts of the code that are not working as expected.

🕵️‍♂️ **Note:** There is one additional hidden bug in the code that is not marked with a `FIXME` comment. You will need to find it by analyzing the failing tests.

## 📜 General Requirements

-   **Version Control:** You are expected to use Git to manage your code. This includes creating an initial commit and subsequent commits for your changes. Your commit messages should be clear and descriptive.
-   **Build and Test:** You should use a build tool to compile your code and run the tests. The project is already set up to be used with a popular Java build tool.
