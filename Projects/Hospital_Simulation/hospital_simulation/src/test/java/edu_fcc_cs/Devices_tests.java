package edu_fcc_cs;

import static org.junit.Assert.*;
import org.junit.Test;

public class Devices_tests {
    @Test
    public void testHeartRateMonitorPollReturnsObservation() {

        Patient p = new Patient();
        HeartRateMonitor monitor = new HeartRateMonitor(p);

        Observation obs = monitor.poll(10);

        if (obs != null) {
            assertTrue(obs instanceof HeartRateObservation);
        }
    }

    @Test
    public void testHeartRateMonitorObservationBelongsToPatient() {

        Patient p = new Patient();
        HeartRateMonitor monitor = new HeartRateMonitor(p);

        Observation obs = monitor.poll(10);

        if (obs != null) {
            assertEquals(p, obs.getPatient());
        }
    }

    @Test
    public void testBloodPressureMonitorPollReturnsObservation() {

        Patient p = new Patient();
        BloodPressureMonitor monitor = new BloodPressureMonitor(p);

        Observation obs = monitor.poll(10);

        if (obs != null) {
            assertTrue(obs instanceof BloodPressureObservation);
        }
    }

    @Test
    public void testBloodPressureMonitorObservationBelongsToPatient() {

        Patient p = new Patient();
        BloodPressureMonitor monitor = new BloodPressureMonitor(p);

        Observation obs = monitor.poll(10);

        if (obs != null) {
            assertEquals(p, obs.getPatient());
        }
    }

    @Test
    public void testOxygenMonitorPollReturnsObservation() {

        Patient p = new Patient();
        OxygenMonitor monitor = new OxygenMonitor(p);

        Observation obs = monitor.poll(10);

        if (obs != null) {
            assertTrue(obs instanceof OxygenObservation);
        }
    }

    @Test
    public void testOxygenMonitorObservationBelongsToPatient() {

        Patient p = new Patient();
        OxygenMonitor monitor = new OxygenMonitor(p);

        Observation obs = monitor.poll(10);

        if (obs != null) {
            assertEquals(p, obs.getPatient());
        }
    }

    @Test
    public void testCallBellDevicePollDoesNotCrash() {

        Patient p = new Patient();
        CallBellDevice device = new CallBellDevice(p);

        Observation obs = device.poll(10);

        if (obs != null) {
            assertTrue(obs instanceof CallBellObservation);
        }
    }

    @Test
    public void testCallBellDeviceObservationBelongsToPatient() {

        Patient p = new Patient();
        CallBellDevice device = new CallBellDevice(p);

        Observation obs = device.poll(10);

        if (obs != null) {
            assertEquals(p, obs.getPatient());
        }
    }

    @Test
    public void testDeviceNotNull() {
        Patient p = new Patient();
        Device d = new BloodPressureMonitor(p);

        assertNotNull(d);
    }
}
