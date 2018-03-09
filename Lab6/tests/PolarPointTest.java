import org.junit.Test;

import static org.junit.Assert.*;

public class PolarPointTest {

    private PolarPoint instance = new PolarPoint(32, 23);


    @Test
    public void getRho() throws Exception {

        double expected = 32d;
        double actual = instance.getRho();

        assertEquals("Return value rho", expected, actual, 0.001);
    }

    @Test
    public void getPhi() throws Exception {

        double expected = 23;
        double actual = instance.getPhi();

        assertEquals("Return value phi", expected, actual, 0.001);
    }

    @Test
    public void toCartesian() throws Exception {

        String expected = "Point";
        String actual = instance.toCartesian()
                .getClass()
                .getTypeName();

        assertEquals("Convert type Point to Cartesian", expected, actual);
    }

}