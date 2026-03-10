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

    @Override
    public String toString() {
        return "Observation: " + getType() + " from patient " +
                patient.getID() + " at time " + time;
    }
}