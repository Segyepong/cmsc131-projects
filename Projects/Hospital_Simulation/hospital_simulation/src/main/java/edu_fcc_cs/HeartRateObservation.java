package edu_fcc_cs;


public class HeartRateObservation extends Observation {

    private int heartRate;

    public HeartRateObservation(Patient patient, int time, int heartRate) {
        super(patient, time);
        this.heartRate = heartRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    @Override
    public String getType() {
        return "Heart Rate";
    }
}