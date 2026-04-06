package edu_fcc_cs;

public class HeartRateMonitor extends Device {

    public HeartRateMonitor(Patient patient) {
        super(patient);
    }

    @Override
    public Observation poll(int time) {
        int bpm = 50 + (int)(Math.random() * 100); 

        HeartRateObservation obs = new HeartRateObservation(patient, time, bpm);

        return obs.dangerous() ? obs : null;
    }
}
