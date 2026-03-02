package edu_fcc_cs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Rectangletest {

    @Test
    public void testinRectangle()
    {
        Rectangle tester = new Rectangle(new Point(4, 3), new Point(6, 8));
        assertEquals(true, tester.inRectangle(new Point(5,5)));
        
    }
    
}
