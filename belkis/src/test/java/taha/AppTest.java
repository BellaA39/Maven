package taha;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 * Test class
 * @author ema dd
 */
public class AppTest {
    
   /**
    * @param testRealAndDistinctRoots do something
    * @return nothing
    */
    @Test
    public void testRealAndDistinctRoots() {
        double a = 1, b = -3, c = 2;
        String expected = "The roots of the equation are real and distinct:\nRoot 1 = 2.0\nRoot 2 = 1.0\n";
        assertEquals(expected, App.solveQuadraticEquation(a, b, c));
    }

}
