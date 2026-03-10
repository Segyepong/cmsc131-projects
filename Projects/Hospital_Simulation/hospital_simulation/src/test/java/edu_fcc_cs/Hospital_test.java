package edu_fcc_cs;
import static org.junit.Assert.*;

import org.junit.Test;
public class Hospital_test {
    @Test
    public void addPatient_test()
    {
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
}
