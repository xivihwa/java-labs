import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Utility class for generating random Participant instances.
 */
public class ParticipantGenerator {

    private static final String[] NAMES = {"Ivan", "Petro", "Olena", "Oksana", "Andriy"};
    private static final String[] SURNAMES = {"Shevchenko", "Kovalenko", "Boyko", "Tkachenko", "Bondarenko"};
    private static final String[] CITIES = {"Kyiv", "Lviv", "Odessa", "Kharkiv", "Dnipro"};
    private static final Random RANDOM = new Random();

    public static Stream<Participant> createParticipants() {
        return Stream.generate(() -> {
            Participant participant = new Participant();
            participant.setFirstName(randomFrom(NAMES));
            participant.setLastName(randomFrom(SURNAMES));
            participant.setBirthDate(LocalDate.now().minusYears(18 + RANDOM.nextInt(42)));
            participant.setCity(randomFrom(CITIES));
            participant.setMonthlyIncome(5000 + RANDOM.nextInt(45000));
            return participant;
        });
    }

    private static String randomFrom(String[] array) {
        return array[RANDOM.nextInt(array.length)];
    }
}