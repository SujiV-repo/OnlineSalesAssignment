package taskone;

import java.util.List;
import java.util.Random;

public class EventSimulatorImpl implements EventSimulator{
    @Override
    public void simulateEvent(List<Outcome> outcomes, int occurences) {
        //totaloccurence array -> to keep track of how many times each outcome has occured
        int[] totalOccurence = new int[outcomes.size()];
        int sumProbability = outcomes.stream().mapToInt(Outcome::getProbability).sum();

        //Random class to generated random numbers
        Random random = new Random();
        //loop to simulate the occurence of events
        for(int i = 0; i < occurences; i++){
            int value = random.nextInt(sumProbability); //generate the random number between 0 the total sum probability
            int totalProbability = 0;
            //looping to capture the each outcome probability
            for (int j = 0; j < outcomes.size(); j++){
                totalProbability += outcomes.get(j).getProbability();
                //if the generated values are in the range of total cumulative probabilites then we have to increment the counter
                if(value < totalProbability){
                    totalOccurence[j]++;
                    break;
                }
            }
        }

        for(int i = 0; i < outcomes.size(); i++){
            System.out.println(outcomes.get(i).getEvent() + "Occurs" + totalOccurence[i]);
        }
    }
}
