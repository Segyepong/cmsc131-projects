package edu_fcc_cs;

public class BloodPressureMonitor extends Device {

    public BloodPressureMonitor(Patient patient) {
        super(patient);
    }

    @Override
    public Observation poll(int time) {

        int systolic = Simulation.getRandomInt(40) + 100;

        return new BloodPressureObservation(patient, time, systolic);
    }
}
