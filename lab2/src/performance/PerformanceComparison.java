package performance;

import models.User;
import validation.Validator;

/**
 * Class for comparing the performance of validation with and without reflection.
 */
public class PerformanceComparison {
    public static void run() {
        User user = new User("Alice", "alice@example.com", 30);
        Validator validator = new Validator();

        // Without reflection
        long start = System.nanoTime();
        if (user.getName() == null || user.getEmail() == null || user.getAge() < 18 || user.getAge() > 100) {
            System.err.println("Validation failed without reflection.");
        }
        long end = System.nanoTime();
        System.out.println("Validation without reflection took: " + (end - start) + " ns");

        // With reflection
        start = System.nanoTime();
        try {
            validator.validate(user);
        } catch (Exception e) {
            System.err.println("Validation failed with reflection: " + e.getMessage());
        }
        end = System.nanoTime();
        System.out.println("Validation with reflection took: " + (end - start) + " ns");
    }
}
