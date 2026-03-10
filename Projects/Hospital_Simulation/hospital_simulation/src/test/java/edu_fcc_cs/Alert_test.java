package edu_fcc_cs;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class Alert_test {
    @Test
public void testAlertCreation() {

    Patient p = new Patient();

    Observation obs =
        new CallBellObservation(p, 20);

    Alert alert = new Alert(obs);

    assertNotNull(alert.toString());
}

}
