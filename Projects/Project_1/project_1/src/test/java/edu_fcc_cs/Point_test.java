package edu_fcc_cs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Point_test 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testgetX()
    {
        Point tester = new Point(4,3);
        assertEquals(4, tester.getX(), 0.0001);
    }

    @Test
    public void testgetY()
    {
        Point tester = new Point(4,3);
        assertEquals(3, tester.getY(), 0.0001);
    }
}
