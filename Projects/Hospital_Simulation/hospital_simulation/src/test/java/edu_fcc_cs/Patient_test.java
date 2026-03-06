package edu_fcc_cs;

import static org.junit.Assert.*;

import org.junit.Test;
public class Patient_test {
    @Test
    public void uuid_test()
    {
        Patient test = new Patient();

        assertNotNull(test.getID());
    }

    @Test
    public void static_patient_create()
    {
        Patient test = Patient.createPatient();

        assertNotNull(test.getID());
    }

    @Test
    public void test_tostring()
    {
        Patient test = Patient.createPatient();
        Patient second = Patient.createPatient();

        assertNotNull(test.toString());
        assertNotEquals(test.toString(), second.toString());
        
    }
}
