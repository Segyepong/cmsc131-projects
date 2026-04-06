package edu_fcc_cs;

public class BloodPressureObservation extends Observation {

    private int systolic;
    private int diastolic;

    public BloodPressureObservation(Patient patient, int time, int systolic, int diastolic) {
        super(patient, time);
        this.systolic = systolic;
        this.diastolic = diastolic;
    }

    @Override
    public String getType() {
        return "Blood Pressure";
    }

    @Override
    public boolean dangerous() {
        return systolic > 180 || diastolic > 120;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + systolic + "/" + diastolic;
    }

    @Override
    public String data() {
        return systolic + "/" + diastolic + " mmHg";
    }
}
