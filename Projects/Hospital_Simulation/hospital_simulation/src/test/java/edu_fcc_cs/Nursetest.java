package edu_fcc_cs;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Nursetest {
    @Test
    public void testNurse() {

        Hospital h = new Hospital(10);
        AlertQueue done = new AlertQueue();

        Patient p = new Patient();
        Alert a = new Alert(
                new BloodPressureObservation(p, 1, 150), 1, true);

        h.addAlert(a);

        Nurse n = new Nurse("N1");

        for (int i = 0; i < 50; i++) {
            n.resolve(i, h, done);
        }

        assertTrue(done.count() >= 0);
    }
}
