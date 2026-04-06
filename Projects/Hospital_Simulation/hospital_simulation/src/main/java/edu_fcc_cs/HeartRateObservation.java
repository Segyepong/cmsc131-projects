package edu_fcc_cs;


public class HeartRateObservation extends Observation {

    private int bpm;

    public HeartRateObservation(Patient patient, int time, int bpm) {
        super(patient, time);
        this.bpm = bpm;
    }

    @Override
    public String getType() {
        return "Heart Rate";
    }

    @Override
    public boolean dangerous() {
        return bpm < 40 || bpm > 130;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + bpm + " bpm";
    }

    @Override
    public String data() {
        return bpm + " bpm";
    }
}