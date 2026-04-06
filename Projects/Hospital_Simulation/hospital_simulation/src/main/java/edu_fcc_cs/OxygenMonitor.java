package edu_fcc_cs;

public class OxygenMonitor extends Device {

    public OxygenMonitor(Patient patient) {
        super(patient);
    }

    @Override
    public Observation poll(int time) {
        int spo2 = 85 + (int)(Math.random() * 15);  

        OxygenObservation obs = new OxygenObservation(patient, time, spo2);

        return obs.dangerous() ? obs : null;
    }
}
