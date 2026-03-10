package edu_fcc_cs;
import java.util.Random;

public class Simulation {
    private static Random rand = new Random();

    private Hospital hospital;
    private int currentTime;

    private int simulationLength = 144;

    public Simulation() {

    }

    public void setup() {
        hospital = new Hospital(100);

        // create some patients
        for (int i = 0; i < 10; i++) {
            hospital.addPatient(Patient.createPatient());
        }

        currentTime = 0;
    }

    public void run() {

        while (currentTime < simulationLength) {

            currentTime++;

        }
    }

    public void process() {
        System.out.println("Simulation complete.");
        System.out.println("Total Patients: " + hospital.getPatientCount());
    }

    public static int getRandomInt(int bound) {
        return rand.nextInt(bound);
    }

    public Hospital getHospital() {
        return hospital;
    }

    public int getCurrentTime() {
        return currentTime;
    }
}
