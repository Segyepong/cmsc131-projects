package edu_fcc_cs;
import java.util.UUID;

public class Patient {
    private UUID id;
    private Device[] devices;

    public Patient(){
        id = UUID.randomUUID();
        devices = new Device[4];

        devices[0] = new HeartRateMonitor(this);
        devices[1] = new BloodPressureMonitor(this);
        devices[2] = new OxygenMonitor(this);
        devices[3] = new CallBellDevice(this);
    }
    
    public UUID getID(){
        return id;
    }

    @Override
    public String toString(){
        return "Patient ID: "+ id.toString();
    }

    public static Patient createPatient(){
        return new Patient();
    }
    
    public Device[] getDevices() {
        return devices;
    }
}
