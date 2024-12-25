import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * Utility class for income analysis, including identifying outliers using IQR.
 */
public class IncomeAnalysisIQR {

    public static Map<String, Long> evaluateIncomeData(List<Participant> participants) {
        List<Integer> sortedIncomes = participants.stream()
                .map(Participant::getMonthlyIncome)
                .sorted()
                .toList();

        int Q1 = sortedIncomes.get((int) Math.ceil(0.25 * sortedIncomes.size()) - 1);
        int Q3 = sortedIncomes.get((int) Math.ceil(0.75 * sortedIncomes.size()) - 1);
        int interquartileRange = Q3 - Q1;

        Map<Boolean, Long> incomeCategories = participants.stream()
                .collect(Collectors.partitioningBy(
                        p -> {
                            int income = p.getMonthlyIncome();
                            return income >= Q1 - 1.5 * interquartileRange && income <= Q3 + 1.5 * interquartileRange;
                        },
                        Collectors.counting()
                ));

        Map<String, Long> result = new HashMap<>();
        result.put("inliers", incomeCategories.get(true));
        result.put("outliers", incomeCategories.get(false));
        return result;
    }
}