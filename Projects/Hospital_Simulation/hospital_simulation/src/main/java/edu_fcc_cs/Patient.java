package edu_fcc_cs;

import java.util.UUID;

public class Patient {

    private UUID id;
    private Device[] devices;

    public Patient() {
        id = UUID.randomUUID();

        devices = new Device[] {
                new BloodPressureMonitor(this),
                new HeartRateMonitor(this),
                new OxygenMonitor(this),
                new CallBellDevice(this)
        };
    }

    public UUID getID() {
        return id;
    }

    public Device[] getDevices() {
        return devices;
    }

    public static Patient createPatient() {
        return new Patient();
    }

    public void generateAlerts(Hospital hospital, int currentTime) {
        for (Device d : devices) {
            Observation obs = d.poll(currentTime);
            if (obs != null) {
                Alert alert = new Alert(obs, currentTime);
                hospital.addAlert(alert);
            }
        }
    }

    @Override
    public String toString() {
        return "Patient ID: " + id;
    }
}