package edu_fcc_cs;

public class CallBellDevice extends Device {

    public CallBellDevice(Patient patient) {
        super(patient);
    }

    @Override
    public Observation poll(int time) {
        boolean pressed = Math.random() < 0.05; 
        if (pressed) {
            return new CallBellObservation(patient, time);
        }
        return null;
    }
}