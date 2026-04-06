package edu_fcc_cs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Hospital_test {
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

        public String data() {
            return "Test Data";
        }
    }

    private Hospital hospital;
    private Patient p1, p2;

    @Before
    public void setup() {
        hospital = new Hospital(5);
        p1 = Patient.createPatient();
        p2 = Patient.createPatient();
        hospital.addPatient(p1);
        hospital.addPatient(p2);
    }

    @Test
    public void testAddAndRetrievePatient() {
        assertEquals(2, hospital.getPatientCount());
        assertEquals(p1, hospital.getPatient(0));
        assertEquals(p2, hospital.getPatient(1));
        assertNull(hospital.getPatient(5));
    }

    @Test
    public void testAddAlertAndPriority() {
        Alert urgentAlert = new Alert(new TestObservation(p1, 1, true), 1);
        Alert normalAlert = new Alert(new TestObservation(p2, 2, false), 2);

        hospital.addAlert(normalAlert);
        hospital.addAlert(urgentAlert);

        Alert next = hospital.getNextAlert();
        assertEquals(urgentAlert, next);

        next = hospital.getNextAlert();
        assertEquals(normalAlert, next);

        assertNull(hospital.getNextAlert());
    }

    @Test
    public void testCompletedAlerts() {
        AlertQueue completed = new AlertQueue();
        hospital.setCompletedQueue(completed);

        Alert alert = new Alert(new TestObservation(p1, 1, true), 1);
        hospital.addCompletedAlert(alert);

        assertEquals(1, completed.count());
        assertEquals(alert, completed.dequeue());
    }

    @Test
    public void testTelemedicine() {
        Alert alert = new Alert(new TestObservation(p1, 1, true), 1);

        assertTrue(hospital.requestTelemedicine(alert));

        assertFalse(hospital.requestTelemedicine(alert));

        hospital.releaseTelemedicine();

        assertTrue(hospital.requestTelemedicine(alert));
    }
}
