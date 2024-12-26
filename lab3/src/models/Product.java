package models;

import annotations.*;

/**
 * Class representing a product.
 */
public class Product {
    @NotNull
    private String name;

    @MinValue(0)
    private int price;

    /**
     * Constructor to create a product.
     *
     * @param name  the name of the product
     * @param price the price of the product
     */
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}