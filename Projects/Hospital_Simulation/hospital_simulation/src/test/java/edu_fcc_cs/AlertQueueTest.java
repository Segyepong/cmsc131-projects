package edu_fcc_cs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AlertQueueTest {
    @Test
public void testQueueFIFO() {
    AlertQueue q = new AlertQueue();

    Patient p = new Patient();

    Alert a1 = new Alert(
        new BloodPressureObservation(p,1,150),1,false);

    Alert a2 = new Alert(
        new BloodPressureObservation(p,2,160),2,false);

    q.enqueue(a1);
    q.enqueue(a2);

    assertEquals(a1, q.dequeue());
    assertEquals(a2, q.dequeue());
}
}
