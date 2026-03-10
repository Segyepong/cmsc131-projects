package edu_fcc_cs;

public class Hospital {
    private Patient[] patients;
    private int patientCount;

    public Hospital(int capacity) {
        patients = new Patient[capacity];
        patientCount = 0;
    }

    public void addPatient(Patient p) {
        if (patientCount < patients.length) {
            patients[patientCount] = p;
            patientCount++;
        }
    }

    public Patient getPatient(int index) {
        if (index >= 0 && index < patientCount) {
            return patients[index];
        }
        return null;
    }

    public int getPatientCount() {
        return patientCount;
    }
}

