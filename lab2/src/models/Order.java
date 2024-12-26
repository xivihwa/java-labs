package models;

import annotations.*;

/**
 * Class representing an order.
 */
public class Order {
    @NotNull
    private User user;

    @NotNull
    private Product product;

    @MinValue(1)
    private int quantity;

    /**
     * Constructor to create an order.
     *
     * @param user     the user placing the order
     * @param product  the product being ordered
     * @param quantity the quantity of the product
     */
    public Order(User user, Product product, int quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }
}