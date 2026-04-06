package edu_fcc_cs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Hospital_test {
    @Test
    public void addPatient_test() {
        Hospital h = new Hospital(10);
        Patient p = new Patient();

        h.addPatient(p);

        assertEquals(1, h.getPatientCount());
    }

    @Test
    public void testGetPatient() {

        Hospital h = new Hospital(10);
        Patient p = new Patient();

        h.addPatient(p);

        assertEquals(p, h.getPatient(0));
    }

    @Test
    public void testHospitalQueue() {
        Hospital h = new Hospital(10);

        Patient p = new Patient();
        Observation obs = new BloodPressureObservation(p, 1, 150);

        Alert a = new Alert(obs, 1, true);

        h.addAlert(a);

        assertNotNull(h.getNextAlert());
    }
}
