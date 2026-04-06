package edu_fcc_cs;

public class CallBellObservation extends Observation {

    public CallBellObservation(Patient patient, int time) {
        super(patient, time);
    }

    @Override
    public String getType() {
        return "Call Bell";
    }

    @Override
    public boolean dangerous() {
        return true;
    }

    @Override
    public String data() {
        return "Patient requested assistance";
    }
}
