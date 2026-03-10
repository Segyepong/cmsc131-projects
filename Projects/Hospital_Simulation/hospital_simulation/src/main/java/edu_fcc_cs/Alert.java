package edu_fcc_cs;

public class Alert {
    private Observation observation;

    public Alert(Observation observation) {
        this.observation = observation;
    }

    @Override
    public String toString() {

        return "ALERT: " + observation.toString();
    }
}
