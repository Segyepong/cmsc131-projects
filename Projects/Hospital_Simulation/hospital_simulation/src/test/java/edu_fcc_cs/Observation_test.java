package edu_fcc_cs;

import static org.junit.Assert.*;

import org.junit.Test;



public class Observation_test {
    @Test
    public void testHeartRateObservationStoresHeartRate() {

        Patient p = new Patient();
        HeartRateObservation obs = new HeartRateObservation(p, 10, 75);

        assertEquals(75, obs.getHeartRate());
    }

    @Test
    public void testHeartRateObservationStoresTime() {

        Patient p = new Patient();
        HeartRateObservation obs = new HeartRateObservation(p, 20, 80);

        assertEquals(20, obs.getTime());
    }

    @Test
    public void testBloodPressureObservationStoresValue() {

        Patient p = new Patient();
        BloodPressureObservation obs =
                new BloodPressureObservation(p, 15, 120);

        assertEquals(120, obs.getSystolic());
    }

    @Test
    public void testBloodPressureObservationStoresPatient() {

        Patient p = new Patient();
        BloodPressureObservation obs =
                new BloodPressureObservation(p, 15, 120);

        assertEquals(p, obs.getPatient());
    }

    @Test
    public void testOxygenObservationStoresLevel() {

        Patient p = new Patient();
        OxygenObservation obs =
                new OxygenObservation(p, 10, 95);

        assertEquals(95, obs.getOxygenLevel());
    }

    @Test
    public void testOxygenObservationStoresTime() {

        Patient p = new Patient();
        OxygenObservation obs =
                new OxygenObservation(p, 10, 95);

        assertEquals(10, obs.getTime());
    }

    @Test
    public void testCallBellObservationStoresPatient() {

        Patient p = new Patient();
        CallBellObservation obs =
                new CallBellObservation(p, 25);

        assertEquals(p, obs.getPatient());
    }

    @Test
    public void testCallBellObservationStoresTime() {

        Patient p = new Patient();
        CallBellObservation obs =
                new CallBellObservation(p, 25);

        assertEquals(25, obs.getTime());
    }
}
