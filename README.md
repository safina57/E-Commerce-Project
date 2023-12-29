# E-Commerce System

## Overview

This is a simple console-based E-Commerce System implemented in Java. The system allows users to sign up, log in, browse products, add products to the shopping cart, and place orders.

## Features

- **User Authentication:** Sign up and log in functionality for both customers and administrators.
- **Product Management:** Administrators can add, update, and remove products from the inventory.
- **Shopping Cart:** Customers can add products to their shopping cart, view the cart, and place orders.
- **Order Management:** Administrators can view and manage customer orders.

## Classes

1. **Main**
   - The main class to run the E-Commerce System.
   - Manages the main menu for signing up, logging in, and accessing admin or user functionalities.

2. **StockManager**
   - Manages the inventory of products.
   - Includes functionality to add, remove, and update product details.

3. **Admin**
   - Manages admin-related functionalities.
   - Allows administrators to sign in and perform actions like managing the product inventory and orders.

4. **CustomerManager**
   - Manages customer-related functionalities.
   - Allows customers to sign up, log in, and perform actions like adding products to the shopping cart and placing orders.

5. **Product**
   - Represents a product with attributes such as ID, name, quantity, price, etc.

6. **ElectronicProduct, ClothingProduct, ToyProduct, FoodProduct**
   - Subclasses of Product, representing specific types of products with additional attributes.

7. **Customer**
   - Represents a customer in the E-Commerce System.
   - Manages actions like adding products to the shopping cart, placing orders, and viewing order history.

## Usage

1. Sign up as a customer or log in as an existing customer.
2. Explore the available products using the main menu options.
3. Add products to the shopping cart.
4. View the shopping cart and proceed to checkout.
5. For administrators, use admin credentials to log in and manage the product inventory and orders.


