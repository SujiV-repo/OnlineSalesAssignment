package testcases;

import org.junit.Test;
import taskone.EventSimulatorImpl;
import taskone.Outcome;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class EventSimulatorImplTest {
    @Test
    void testSimulateEvent() {

        List<Outcome> outcomes = new ArrayList<>();
        outcomes.add(new Outcome("Event1", 10));
        outcomes.add(new Outcome("Event2", 30));
        outcomes.add(new Outcome("Event3", 15));
        outcomes.add(new Outcome("Event4", 15));
        outcomes.add(new Outcome("Event5", 30));

        EventSimulatorImpl eventSimulator = new EventSimulatorImpl();
        int occurrences = 1000;

        eventSimulator.simulateEvent(outcomes, occurrences);

        // You might want to check if the occurrences are within an acceptable range
        // based on the probabilities of each outcome.
        // Check if the total occurrences match the expected value.
        int totalOccurrences = outcomes.stream().mapToInt(Outcome::getProbability).sum();
        assertTrue(totalOccurrences == occurrences);
    }

    @Test
    void testSimulateEventWithEmptyOutcomes() {
        List<Outcome> outcomes = new ArrayList<>();
        EventSimulatorImpl eventSimulator = new EventSimulatorImpl();
        int occurrences = 100;

        // If there are no outcomes, the method should not throw an exception
        // and should not print anything to the console.
        eventSimulator.simulateEvent(outcomes, occurrences);
    }
}
