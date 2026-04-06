package edu_fcc_cs;

public class BloodPressureMonitor extends Device {

    public BloodPressureMonitor(Patient patient) {
        super(patient);
    }

    @Override
    public Observation poll(int time) {
        int systolic = 100 + (int)(Math.random() * 100);  
        int diastolic = 60 + (int)(Math.random() * 70);  

        BloodPressureObservation obs = new BloodPressureObservation(patient, time, systolic, diastolic);

        return obs.dangerous() ? obs : null;
    }
}
