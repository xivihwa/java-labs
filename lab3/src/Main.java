import models.User;
import models.Product;
import models.Order;
import validation.Validator;
import performance.PerformanceComparison;

/**
 * Main class demonstrating the use of the validator.
 */

public class Main {
    public static void main(String[] args) {
        Validator validator = new Validator();

        // Valid objects
        User validUser = new User("Alice", "alice@example.com", 30);
        Product validProduct = new Product("Laptop", 1000);
        Order validOrder = new Order(validUser, validProduct, 2);

        // Invalid objects
        User invalidUser = new User(null, "invalid", 15); // Errors: name = null, email, age
        Product invalidProduct = new Product("Table", -10); // Errors: price < 0
        Order invalidOrder = new Order(null, validProduct, 0); // Errors: user = null, quantity < 1

        // Validation of valid objects
        try {
            validator.validate(validUser);
            validator.validate(validProduct);
            validator.validate(validOrder);
            System.out.println("Valid objects passed validation!");
        } catch (Exception e) {
            System.err.println("Validation error for valid objects: " + e.getMessage());
        }

        // Validation of invalid objects
        try {
            validator.validate(invalidUser);
        } catch (Exception e) {
            System.err.println("Validation error for invalidUser: " + e.getMessage());
        }

        try {
            validator.validate(invalidProduct);
        } catch (Exception e) {
            System.err.println("Validation error for invalidProduct: " + e.getMessage());
        }

        try {
            validator.validate(invalidOrder);
        } catch (Exception e) {
            System.err.println("Validation error for invalidOrder: " + e.getMessage());
        }
    }
}
