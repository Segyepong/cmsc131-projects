package edu_fcc_cs;
import java.util.UUID;

public class Patient {
    private UUID id;

    public Patient(){
        id = UUID.randomUUID();
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
}
