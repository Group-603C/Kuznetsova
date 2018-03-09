import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    private Point instance = new Point(12, 24, 36);


    @Test
    public void getX() throws Exception {

        double expected = 12d;
        double actual = instance.getX();

        assertEquals("Return value X", expected, actual, 0.001);
    }

    @Test
    public void getY() throws Exception {

        double expected = 24d;
        double actual = instance.getY();

        assertEquals("Return value Y", expected, actual, 0.001);
    }

    @Test
    public void getZ() throws Exception {

        double expected = 36d;
        double actual = instance.getZ();

        assertEquals("Return value Z", expected, actual, 0.001);
    }

    @Test
    public void distanceTo() throws Exception {

        double expected = 131.59d;
        double actual = new Point(12, 144, 90).distanceTo(instance);

        assertEquals("Return value Z", expected, actual, 0.001);
    }

    @Test
    public void toPolar() throws Exception {

        String expected = "PolarPoint";
        String actual = instance.toPolar()
                .getClass()
                .getTypeName();

        assertEquals("Convert type Point to PolarPoint", expected, actual);
    }

    @Test
    public void toCylindrical() throws Exception {

        String expected = "CylindricalPoint";
        String actual = instance.toCylindrical()
                .getClass()
                .getTypeName();

        assertEquals("Convert type Point to CylindricalPoint", expected, actual);
    }



}