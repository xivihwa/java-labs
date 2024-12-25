/**
 * Data class representing statistical metrics for monthly income analysis.
 */
public record Data(
        int minIncome,
        int maxIncome,
        double averageIncome,
        double standardDeviation) {
}
