package edu_fcc_cs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Nursetest {

    private static class TestObservation extends Observation {
        private boolean isDangerous;

        public TestObservation(Patient p, int time, boolean isDangerous) {
            super(p, time);
            this.isDangerous = isDangerous;
        }

        @Override
        public String getType() {
            return "TestObservation";
        }

        @Override
        public boolean dangerous() {
            return isDangerous;
        }

        @Override
        public String data() {
            return "Test Data";
        }
    }

    private static class TestNurse extends Nurse {
        public TestNurse(String id) {
            super(id);
        }

        @Override
        public void resolve(int time, Hospital hospital) {
            Alert alert;
            while ((alert = hospital.getNextAlert()) != null) {
                alert.resolve(time);
                hospital.addCompletedAlert(alert);
            }
        }
    }

    private Hospital hospital;
    private Nurse nurse;
    private Patient patient;
    private AlertQueue completedQueue;

    @Before
    public void setup() {
        hospital = new Hospital(2);
        patient = Patient.createPatient();
        hospital.addPatient(patient);

        nurse = new TestNurse("Test Nurse");

        completedQueue = new AlertQueue();
        hospital.setCompletedQueue(completedQueue);
    }

    @Test
    public void testResolveNormalAlert() {
        Alert alert = new Alert(new TestObservation(patient, 1, false), 1);
        hospital.addAlert(alert);

        nurse.resolve(10, hospital);

        Alert completed = completedQueue.dequeue();
        assertNotNull(completed);
        assertEquals(alert, completed);
        assertEquals(10, completed.getEndTime());
    }

    @Test
    public void testResolveUrgentAlert() {
        Alert urgent = new Alert(new TestObservation(patient, 1, true), 1);
        hospital.addAlert(urgent);

        nurse.resolve(20, hospital);

        Alert completed = completedQueue.dequeue();
        assertNotNull(completed);
        assertEquals(urgent, completed);
        assertEquals(20, completed.getEndTime());
        assertTrue(completed.isUrgent());
    }

    @Test
    public void testTelemedicineAttempt() {
        Alert alert = new Alert(new TestObservation(patient, 2, true), 2);
        hospital.addAlert(alert);

        assertTrue("Telemedicine should be available", hospital.requestTelemedicine(alert));

        nurse.resolve(30, hospital);

        Alert completed = completedQueue.dequeue();
        assertNotNull(completed);
        assertEquals(alert, completed);
        assertEquals(30, completed.getEndTime());
    }
}
