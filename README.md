# E-Commerce System Documentation

## Overview

This E-Commerce System is a console-based application implemented in Java, providing features for user authentication, product management, shopping cart operations, order placement, and two optional features: product rating and "My Favorites" list (Wish List).

## Design Decisions

### Modular Structure

The project maintains a modular structure, ensuring clarity, maintainability, and scalability. Each class is designed for a specific set of functionalities.

### User Authentication

Both customers and administrators have authentication functionalities. Customers can sign up, log in, and perform shopping-related actions. Administrators have access to product and order management.

### Product Hierarchy

A class hierarchy is implemented for products, allowing the representation of different product types. This design facilitates easy extension for adding new product categories.

### Search Interface

A search interface is implemented to allow users to search for products based on different criteria, enhancing user experience and facilitating product discovery.

## Optional Features

1. **Product Rating:**
   - Products can be rated by customers. This feature enhances user interaction and provides valuable feedback for products.

2. **Wish List (My Favorites):**
   - Customers can add products to their Wish List, creating a curated list of desired items for future reference.

## Object-Oriented Programming (OOP) Implementation

### Classes

1. **Main:**
   - Manages the application's main menu, user authentication, and navigation to admin or user functionalities.

2. **StockManager:**
   - Manages the inventory of products, providing functionality to add, remove, and update product details.

3. **Admin:**
   - Handles admin-related functionalities, including sign-in and actions like product inventory and order management.

4. **CustomerManager:**
   - Manages customer-related functionalities such as sign-up, log-in, shopping cart actions, order placement, and interactions with the Wish List.

5. **Product:**
   - Represents a product with attributes like ID, name, quantity, price, and now includes a rating.

6. **ElectronicProduct, ClothingProduct, ToyProduct, FoodProduct:**
   - Subclasses of Product, representing specific product types with additional attributes.

7. **Customer:**
   - Represents a customer in the system, managing shopping cart operations, order placement, product rating, and the Wish List.

8. **WishList:**
   - A class representing the Wish List, allowing customers to add and remove products.

9. **Search:**
   - An interface defining methods for searching products based on different criteria.

## Usage

### Sign Up or Log In:

- Sign up as a customer or log in as an existing customer.
- Use admin credentials to log in as an administrator.

### Explore Products:

- Navigate through available products using the main menu.

### Shopping Cart:

- Add products to the shopping cart.
- View the shopping cart and proceed to checkout.

### Optional Features:

- **Product Rating:**
  - Rate products based on your experience.
- **Wish List (My Favorites):**
  - Add and manage products in your Wish List.

### Search for Products:

- Utilize the search interface to find products based on name or category.

### Administrator Actions:

- Use admin credentials to log in and manage product inventory and orders.

