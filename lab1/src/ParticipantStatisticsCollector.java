import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.Collections;

/**
 * Custom collector for calculating income statistics from a stream of Participants.
 */
public class ParticipantStatisticsCollector implements Collector<Participant, List<Integer>, Data> {

    @Override
    public Supplier<List<Integer>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Integer>, Participant> accumulator() {
        return (list, participant) -> list.add(participant.getMonthlyIncome());
    }

    @Override
    public BinaryOperator<List<Integer>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<Integer>, Data> finisher() {
        return incomes -> {
            int min = incomes.stream().min(Integer::compare).orElse(0);
            int max = incomes.stream().max(Integer::compare).orElse(0);
            double average = incomes.stream().mapToDouble(i -> i).average().orElse(0.0);
            double stdDev = Math.sqrt(incomes.stream().mapToDouble(i -> Math.pow(i - average, 2)).average().orElse(0.0));
            return new Data(min, max, average, stdDev);
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.singleton(Characteristics.CONCURRENT);
    }
}
