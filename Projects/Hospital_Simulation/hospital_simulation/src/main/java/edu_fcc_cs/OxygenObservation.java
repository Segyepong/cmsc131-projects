package edu_fcc_cs;

public class OxygenObservation extends Observation {

    private int spo2;

    public OxygenObservation(Patient patient, int time, int spo2) {
        super(patient, time);
        this.spo2 = spo2;
    }

    @Override
    public String getType() {
        return "Oxygen Saturation";
    }

    @Override
    public boolean dangerous() {
        return spo2 < 90;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + spo2 + "%";
    }

    @Override
    public String data() {
        return spo2 + "%";
    }
}
