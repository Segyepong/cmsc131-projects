package edu_fcc_cs;

public class BloodPressureObservation extends Observation {
    private int systolic;

    public BloodPressureObservation(Patient patient, int time, int systolic) {
        super(patient, time);
        this.systolic = systolic;
    }

    public int getSystolic() {
        return systolic;
    }

    public String getType() {
        return "Blood Pressure";
    }
}
