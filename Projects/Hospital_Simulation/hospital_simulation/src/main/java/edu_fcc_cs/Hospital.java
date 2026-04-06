package edu_fcc_cs;

public class Hospital {

    private Patient[] patients;
    private int patientCount;

    private AlertQueue urgentQueue = new AlertQueue();
    private AlertQueue normalQueue = new AlertQueue();

    private AlertQueue completedQueue;

    private int maxTelemedicine = 1;
    private int activeTelemedicine = 0;

    public Hospital(int capacity) {
        patients = new Patient[capacity];
        patientCount = 0;
    }

    public void addPatient(Patient p) {
        if (patientCount < patients.length) {
            patients[patientCount++] = p;
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

    public void update(int time) {
        for (int i = 0; i < patientCount; i++) {
            patients[i].generateAlerts(this, time);
        }
    }

    public void addAlert(Alert a) {
        if (a.isUrgent()) {
            urgentQueue.enqueue(a);
        } else {
            normalQueue.enqueue(a);
        }
    }

    public Alert getNextAlert() {
        Alert a = urgentQueue.dequeue();
        if (a == null) {
            a = normalQueue.dequeue();
        }
        return a;
    }

    public void setCompletedQueue(AlertQueue q) {
        this.completedQueue = q;
    }

    public void addCompletedAlert(Alert a) {
        if (completedQueue != null) {
            completedQueue.enqueue(a);
        }
    }

    public boolean requestTelemedicine(Alert a) {
        if (activeTelemedicine < maxTelemedicine) {
            activeTelemedicine++;
            return true;
        }
        return false;
    }

    public void releaseTelemedicine() {
        if (activeTelemedicine > 0) {
            activeTelemedicine--;
        }
    }
}