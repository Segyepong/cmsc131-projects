package edu_fcc_cs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

public class Circletest {

    @Test
    public void testinCircle()
    {
        Circle tester = new Circle(new Point(3, 5), 3);
        assertEquals(true, tester.inCircle(new Point(5,7)));
    }
    
}
