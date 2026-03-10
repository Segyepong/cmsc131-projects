package edu_fcc_cs;

public abstract class Device {

    protected Patient patient;

    public Device(Patient patient) {
        this.patient = patient;
    }

    public abstract Observation poll(int time);
}