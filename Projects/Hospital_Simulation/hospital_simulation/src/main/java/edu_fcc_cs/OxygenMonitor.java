package edu_fcc_cs;

public class OxygenMonitor extends Device {

    public OxygenMonitor(Patient patient) {
        super(patient);
    }

    @Override
    public Observation poll(int time) {

        int oxygen = Simulation.getRandomInt(10) + 90;

        return new OxygenObservation(patient, time, oxygen);
    }
}
