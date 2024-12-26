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
        // Example usage of validator
        User user = new User("Violetta", "violetta@example.com", 25);
        Product product = new Product("Laptop", 99);
        Order order = new Order(user, product, 2);

        Validator validator = new Validator();

        try {
            validator.validate(user);
            validator.validate(product);
            validator.validate(order);
            System.out.println("All objects are valid.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Performance comparison
        PerformanceComparison.run();
    }
}
