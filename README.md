# Bookstore CLI Application

A console-based Java application for managing a bookstore inventory, performing sales, and tracking cash flow. This project demonstrates object-oriented programming concepts including inheritance, polymorphism, encapsulation, constructor chaining, and interface implementation in Java 24.

## Features

### Inventory Management
- Books: Manage items with Title, Author, Price, and Copies.
- Magazines: Manage magazines with issue dates and quantities.
- Disc Magazines: Specialized magazines with discs included.
- Tickets: Simple saleable items with descriptions and prices.
- Gaming Accessories: Manage gaming mice and gaming keyboards.

### CRUD Operations
- Add items
- Edit items
- Delete items
- List items

### Sales System
- Sell items from inventory
- Update internal Cash Till
- Reduce inventory quantity after sale

### Data Generation
- Uses JavaFaker to populate inventory with sample data.

### Menu System
- Interactive console menu for easy navigation.

---

# Lab 1: Analysis

## Problem Statement

My niche store sells gaming accessories for gamers and students. The store includes products such as gaming keyboards and gaming mice. These products help improve gaming and computer performance. Customers can browse, edit, and purchase different gaming accessories. The system stores product details and manages inventory.

---

## Noun / Verb Table

| Nouns | Verbs |
|---|---|
| GamingAccessory | Add |
| GamingMouse | Edit |
| GamingKeyboard | Sell |
| Brand | Update |
| DPI | Display |
| SwitchType | Delete |

---

## Synonyms

- Mouse = Pointer Device
- Keyboard = Typing Device

---

## Niche Design

My custom niche is Gaming Accessories.

### Abstract Parent Class
- GamingAccessory

### Concrete Child Classes
- GamingMouse
- GamingKeyboard

### Class Hierarchy

Product → GamingAccessory → GamingMouse  
Product → GamingAccessory → GamingKeyboard

---

## Class Hierarchy

![Class Diagram](documentation/bookstore-2026-01-30-142617.png)

The hierarchy implements the following structure:

- SaleableItem (Interface): Defines sellItem() and getPrice()
- Editable (Abstract): Handles console input and parsing
- Product: Base product class
- Publication: Base class for books and magazines
- GamingAccessory: Abstract parent class for gaming products
- GamingMouse: Concrete gaming mouse class
- GamingKeyboard: Concrete gaming keyboard class

---

## Prerequisites

- Java JDK 24
- Maven 3.6+

---

## Dependencies

### JavaFaker
Used for generating random test data.

### JUnit 5
Used for unit testing.

---

## How to Run

### Compile the project

```bash
mvn clean compile
```

### Run the application

```bash
mvn exec:java
```

---

## Usage

When the application starts, sample data is automatically generated.

Menu:

```text
***********************
 1. Add Items
 2. Edit Items
 3. Delete Items
 4. Sell item(s)
 5. List items
99. Quit
***********************
```

### Add Items
Add Books, Magazines, Tickets, Gaming Mouse, or Gaming Keyboard.

### Edit Items
Edit existing product details.

### Sell Items
Sell products and update the Cash Till balance.

### List Items
Display all inventory items.

---

## Running Tests

Run tests using Maven:

```bash
mvn test
```

---

## Project Structure

```text
src/
├── main/
│   └── java/
│       └── bookstore/
│           ├── Main.java
│           ├── App.java
│           └── pojos/
│               ├── Editable.java
│               ├── SaleableItem.java
│               ├── Product.java
│               ├── Publication.java
│               ├── Book.java
│               ├── Magazine.java
│               ├── DiscMag.java
│               ├── Ticket.java
│               ├── GamingAccessory.java
│               ├── GamingMouse.java
│               ├── GamingKeyboard.java
│               └── CashTill.java
└── test/
    └── java/
        └── bookstore/
            └── pojos/
```

---

## Constructor Chaining

This project demonstrates constructor chaining using super() across multiple levels of inheritance.

Example:

Product → GamingAccessory → GamingMouse

---

## Java Bean Standards

All classes follow Java Bean standards:
- Private fields
- Public getters/setters
- No-argument constructors
- Loaded constructors
- toString()
- equals()
- hashCode()

---

## Author

Gagandeepn Singh
CSD214 - Programming Concepts II  
Summer 2026