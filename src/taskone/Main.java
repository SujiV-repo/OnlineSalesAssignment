package taskone;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Outcome> dice = new ArrayList<>();
        //Creating dice object and giving probability for every occurence
        dice.add(new Outcome(1, 23));
        dice.add(new Outcome(2, 10));
        dice.add(new Outcome(3, 14));
        dice.add(new Outcome(4, 5));
        dice.add(new Outcome(5, 30));
        dice.add(new Outcome(6, 18));

        //Creating coin object and giving probability for every occurence
        List<Outcome> coin = new ArrayList<>();
        coin.add(new Outcome("Heads", 40));
        coin.add(new Outcome("Tails", 60));

        EventSimulator simulator = new EventSimulatorImpl();
        simulator.simulateEvent(dice, 1000);
        simulator.simulateEvent(coin, 1000);
    }
}