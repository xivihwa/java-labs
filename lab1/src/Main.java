import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Demonstrates analysis and processing of Participant data, including grouping,
 * statistical calculations, and identifying income outliers.
 */
public class Main {

    public static void main(String[] args) {
        int maxParticipants = 500;
        String excludedCity = "Kyiv";

        // Generate participants and apply initial filters
        List<Participant> participants = ParticipantGenerator.createParticipants()
                .filter(participant -> !excludedCity.equals(participant.getCity()))
                .limit(maxParticipants)
                .collect(Collectors.toList());

        participants.forEach(System.out::println);

        // Group participants by city, excluding those over 100 years old
        Map<String, List<Participant>> participantsByCity = participants.stream()
                .filter(participant -> participant.getBirthDate().isAfter(LocalDate.now().minusYears(100)))
                .collect(Collectors.groupingBy(Participant::getCity));

        participantsByCity.forEach((city, list) ->
                System.out.println("Number of participants in '" + city + "': " + list.size()));

        // Calculate statistics for participant incomes
        Data incomeStats = participants.stream()
                .collect(new ParticipantStatisticsCollector());
        System.out.println(incomeStats);

        // Analyze income data for potential outliers
        Map<String, Long> incomeOutliers = IncomeAnalysisIQR.evaluateIncomeData(participants);
        System.out.println(incomeOutliers);
    }
}