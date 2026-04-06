package edu_fcc_cs;

import java.util.Random;

public class Alert {

    public enum Severity {
        URGENT, NORMAL
    }

    private Observation observation;
    private int startTime;
    private int endTime;
    private Severity severity;

    public Alert(Observation observation, int startTime) {
        this.observation = observation;
        this.startTime = startTime;
        this.endTime = -1;

        if (observation.dangerous()) {
            severity = Severity.URGENT;
        } else {
            severity = Severity.NORMAL;
        }
    }

    public Observation getObservation() {
        return observation;
    }

    public Patient getPatient() {
        return observation.getPatient();
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void resolve(int time) {
        endTime = time;
    }

    public int getResolutionTime() {
        if (endTime == -1)
            return 0;
        return endTime - startTime;
    }

    public Severity getSeverity() {
        return severity;
    }

    public boolean isUrgent() {
        return severity == Severity.URGENT;
    }

    public String toString() {
        return "Patient=" + getPatient() +
                " Obs=" + observation.data() +
                " Severity=" + severity +
                " Start=" + startTime +
                " End=" + endTime;
    }
}