package taskone;

public class Outcome {
    private Object event;
    private int probability;

    public Outcome(Object event, int probability) {
        this.event = event;
        this.probability = probability;
    }

    public Object getEvent() {
        return event;
    }

    public void setEvent(Object event) {
        this.event = event;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

}
