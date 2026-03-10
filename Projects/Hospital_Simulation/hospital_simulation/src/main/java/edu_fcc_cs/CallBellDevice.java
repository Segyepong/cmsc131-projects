package edu_fcc_cs;

public class CallBellDevice extends Device {

    public CallBellDevice(Patient patient) {
        super(patient);
    }

    @Override
    public Observation poll(int time) {

        if (Simulation.getRandomInt(20) == 0) {
            return new CallBellObservation(patient, time);
        }

        return null;
    }
}