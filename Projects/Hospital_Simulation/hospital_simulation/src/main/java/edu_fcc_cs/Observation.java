package edu_fcc_cs;

public abstract class Observation {

    protected Patient patient;
    protected int time;

    public Observation(Patient patient, int time) {
        this.patient = patient;
        this.time = time;
    }

    public Patient getPatient() {
        return patient;
    }

    public int getTime() {
        return time;
    }

    public abstract String getType();

    public abstract boolean dangerous();

    public abstract String data();

    @Override
    public String toString() {
        return getType() + " at time " + time +
                " for patient " + patient.getID();
    }
}