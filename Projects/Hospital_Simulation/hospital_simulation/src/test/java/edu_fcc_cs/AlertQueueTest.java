package edu_fcc_cs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class AlertQueueTest {
    private static class TestObservation extends Observation {
        public TestObservation(Patient p, int time) {
            super(p, time);
        }

        @Override
        public String getType() {
            return "TestObservation";
        }

        @Override
        public boolean dangerous() {
            return false;
        }

        public String data() {
            return "Test Data";
        }
    }

    @Test
    public void testEnqueueDequeue() {
        AlertQueue queue = new AlertQueue();
        Patient p1 = Patient.createPatient();
        Patient p2 = Patient.createPatient();

        Alert a1 = new Alert(new TestObservation(p1, 1), 1);
        Alert a2 = new Alert(new TestObservation(p2, 2), 2);

        assertEquals(0, queue.count());

        queue.enqueue(a1);
        assertEquals(1, queue.count());

        queue.enqueue(a2);
        assertEquals(2, queue.count());

        Alert first = queue.dequeue();
        assertEquals(a1, first);
        assertEquals(1, queue.count());

        Alert second = queue.dequeue();
        assertEquals(a2, second);
        assertEquals(0, queue.count());

        // Dequeue from empty queue
        assertNull(queue.dequeue());
        assertEquals(0, queue.count());
    }

    @Test
    public void testQueueOrder() {
        AlertQueue queue = new AlertQueue();
        Patient p = Patient.createPatient();

        // Enqueue multiple alerts
        Alert[] alerts = new Alert[5];
        for (int i = 0; i < 5; i++) {
            alerts[i] = new Alert(new TestObservation(p, i), i);
            queue.enqueue(alerts[i]);
        }

        // Dequeue should return in the same order
        for (int i = 0; i < 5; i++) {
            Alert a = queue.dequeue();
            assertEquals(alerts[i], a);
        }

        // Queue should be empty
        assertEquals(0, queue.count());
        assertNull(queue.dequeue());
    }
}
