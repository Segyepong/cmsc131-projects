package edu_fcc_cs;

import java.util.Random;

public class Simulation {

    private static Random rand = new Random();

    private Hospital hospital;
    private Nurse[] nurses;
    private AlertQueue completedQueue;

    private int currentTime;
    private int endTime = 1000;

    public Simulation() {
    }

    public static Random getRandom() {
        return rand;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public AlertQueue getCompletedQueue() {
        return completedQueue;
    }

    public void setup() {

        hospital = new Hospital(10);

        for (int i = 0; i < 10; i++) {
            hospital.addPatient(Patient.createPatient());
        }

        nurses = new Nurse[2];
        nurses[0] = new Nurse("Nurse A");
        nurses[1] = new Nurse("Nurse B");

        completedQueue = new AlertQueue();

        hospital.setCompletedQueue(completedQueue);

        currentTime = 0;
    }

    public void run() {

        while (currentTime < endTime) {

            hospital.update(currentTime);

            for (int i = 0; i < nurses.length; i++) {
                nurses[i].resolve(currentTime, hospital);
            }

            currentTime += 10;
        }
    }

    public void process() {

        int sum = 0;
        int max = 0;
        int count = 0;

        Alert a;

        while ((a = completedQueue.dequeue()) != null) {
            int t = a.getResolutionTime();

            sum += t;
            if (t > max)
                max = t;
            count++;
        }

        if (count > 0) {
            System.out.println("Average time: " + (sum / count));
            System.out.println("Max time: " + max);
        } else {
            System.out.println("No completed alerts.");
        }
    }
}