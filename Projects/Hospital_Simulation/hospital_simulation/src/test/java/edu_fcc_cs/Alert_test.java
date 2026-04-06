package edu_fcc_cs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Alert_test {
    private static class TestObservation extends Observation {
        private boolean dangerous;
        private String data;

        public TestObservation(Patient p, int time, boolean dangerous, String data) {
            super(p, time);
            this.dangerous = dangerous;
            this.data = data;
        }

        @Override
        public String getType() {
            return "TestObservation";
        }

        @Override
        public boolean dangerous() {
            return dangerous;
        }

        public String data() {
            return data;
        }
    }

    @Test
    public void testAlertCreationNormal() {
        Patient patient = Patient.createPatient();
        Observation obs = new TestObservation(patient, 5, false, "Normal Data");

        Alert alert = new Alert(obs, 5);

        assertEquals(patient, alert.getPatient());
        assertEquals(5, alert.getStartTime());
        assertEquals(Alert.Severity.NORMAL, alert.getSeverity());
        assertFalse(alert.isUrgent());
        assertEquals(obs, alert.getObservation());
        assertEquals(0, alert.getResolutionTime());
    }

    @Test
    public void testAlertCreationUrgent() {
        Patient patient = Patient.createPatient();
        Observation obs = new TestObservation(patient, 2, true, "Critical Data");

        Alert alert = new Alert(obs, 2);

        assertEquals(Alert.Severity.URGENT, alert.getSeverity());
        assertTrue(alert.isUrgent());
    }

    @Test
    public void testAlertResolve() {
        Patient patient = Patient.createPatient();
        Observation obs = new TestObservation(patient, 0, true, "Critical Data");

        Alert alert = new Alert(obs, 0);
        alert.resolve(10);

        assertEquals(10, alert.getEndTime());
        assertEquals(10, alert.getResolutionTime());
    }

    @Test
    public void testAlertToString() {
        Patient patient = Patient.createPatient();
        Observation obs = new TestObservation(patient, 1, true, "Some Data");

        Alert alert = new Alert(obs, 1);
        alert.resolve(5);

        String str = alert.toString();
        assertTrue(str.contains("Some Data"));
        assertTrue(str.contains("Patient="));
        assertTrue(str.contains("Severity=URGEN"));
        assertTrue(str.contains("Start=1"));
        assertTrue(str.contains("End=5"));
    }

}
