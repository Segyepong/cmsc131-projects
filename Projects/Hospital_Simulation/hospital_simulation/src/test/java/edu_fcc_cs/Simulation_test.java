package edu_fcc_cs;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class Simulation_test {
    @Test
    public void testSetupCreatesHospital() {

        Simulation sim = new Simulation();
        sim.setup();

        assertNotNull(sim.getHospital());
    }

    @Test
    public void testRunAdvancesTime() {

        Simulation sim = new Simulation();
        sim.setup();

        sim.run();

        assertTrue(sim.getCurrentTime() > 0);
    }

    @Test
    public void testRandomNumber() {

        int num = Simulation.getRandomInt(10);

        assertTrue(num >= 0 && num < 10);
    }
}
