package edu_fcc_cs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Observation_test {
    private Patient patient;

    @Before
    public void setup() {
        patient = Patient.createPatient();
    }

    @Test
    public void testBloodPressureObservationNormal() {
        BloodPressureObservation obs = new BloodPressureObservation(patient, 5, 120, 80);

        assertEquals(patient, obs.getPatient());
        assertEquals(5, obs.getTime());
        assertEquals("Blood Pressure", obs.getType());
        assertFalse(obs.dangerous());
        assertEquals("120/80 mmHg", obs.data());
        assertTrue(obs.toString().contains("Blood Pressure"));
        assertTrue(obs.toString().contains("120/80"));
    }

    @Test
    public void testBloodPressureObservationDangerous() {
        BloodPressureObservation obs = new BloodPressureObservation(patient, 10, 190, 125);

        assertTrue(obs.dangerous());
        assertEquals("190/125 mmHg", obs.data());
    }

    @Test
    public void testOtherObservationSubclass() {
        class HeartRateObservation extends Observation {
            private int bpm;

            public HeartRateObservation(Patient p, int time, int bpm) {
                super(p, time);
                this.bpm = bpm;
            }

            @Override
            public String getType() {
                return "Heart Rate";
            }

            @Override
            public boolean dangerous() {
                return bpm < 50 || bpm > 120;
            }

            @Override
            public String data() {
                return bpm + " bpm";
            }
        }

        HeartRateObservation hrObs = new HeartRateObservation(patient, 3, 130);

        assertEquals("Heart Rate", hrObs.getType());
        assertTrue(hrObs.dangerous());
        assertEquals("130 bpm", hrObs.data());
        assertTrue(hrObs.toString().contains("Heart Rate"));
        assertTrue(hrObs.toString().contains("3"));
    }
}
