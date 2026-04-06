package edu_fcc_cs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

public class Simulation_test {

    private Simulation sim;

    @Before
    public void setup() {
        sim = new Simulation();
        sim.setup();
    }

    @Test
    public void testSetup() {
        assertNotNull(sim);
        assertEquals(10, sim.getHospital().getPatientCount());
    }

    @Test
    public void testRunSimulationGeneratesCompletedAlerts() {
        sim.run();

        AlertQueue completed = sim.getCompletedQueue();
        int completedCount = completed.count();

        assertTrue(completedCount > 0);

        Alert a = completed.dequeue();
        assertNotNull(a);
        assertTrue(a.getResolutionTime() > 0);
        assertNotNull(a.getPatient());
        assertNotNull(a.getObservation());
    }

    @Test
    public void testProcessOutputsStatistics() {
        sim.run();

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        sim.process();

        String output = outContent.toString();
        assertTrue(output.contains("Average time:") || output.contains("No completed alerts."));
        assertTrue(output.contains("Max time:") || output.contains("No completed alerts."));
    }
}