import static org.junit.Assert.*;

public class CalculatorTest
{
    @org.junit.Test
    public void calculate() throws Exception
    {
        Calculator exemplar1 = new Calculator();
        double expect = 21d;
        double actual = exemplar1.calculate("4*5-2+3");
        assertEquals("One test", expect, actual, 0.0001);
    }
}