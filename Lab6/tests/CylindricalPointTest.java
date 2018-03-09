import org.junit.Test;

import static org.junit.Assert.*;

public class CylindricalPointTest {

    private CylindricalPoint instance = new CylindricalPoint(45, 90, 459);


    @Test
    public void getRho() throws Exception {

        double expected = 45d;
        double actual = instance.getRho();

        assertEquals("", expected, actual, 0.001);
    }

    @Test
    public void getPhi() throws Exception {

        double expected = 90;
        double actual = instance.getPhi();

        assertEquals("", expected, actual, 0.001);
    }

    @Test
    public void getZ() throws Exception {

        double expected = 459d;
        double actual = instance.getZ();

        assertEquals("", expected, actual, 0.001);
    }

    @Test
    public void toCartesian() throws Exception {

        String expected = "Point";
        String actual = instance.toCartesian()
                .getClass()
                .getTypeName();

        assertEquals("Convert type CylindricalPoint to Cartesian", expected, actual);
    }



}