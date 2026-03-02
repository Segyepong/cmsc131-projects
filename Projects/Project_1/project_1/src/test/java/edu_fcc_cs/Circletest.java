package edu_fcc_cs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

public class Circletest {

    @Test
    public void testgetX()
    {
        Point tester = new Point(4,3);
        assertEquals(4, tester.getX(), 0.0001);
    }
    
}
