package edu_fcc_cs;

public class HeartRateMonitor extends Device {

    public HeartRateMonitor(Patient patient) {
        super(patient);
    }

    @Override
    public Observation poll(int time) {

        int rate = Simulation.getRandomInt(40) + 60;

        return new HeartRateObservation(patient, time, rate);
    }
}
