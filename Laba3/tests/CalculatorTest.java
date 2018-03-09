import org.junit.Test;

import static java.lang.Double.NaN;
import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator instance = new Calculator();

    @Test
    public void expressionNull() {

        assertEquals("Null in expression", NaN, instance.calculate(null), 0.001);
    }

    @Test
    public void operationIncorrect() {

        assertEquals("Incorrect placement of operators", NaN, instance.calculate("121 -- 4"), 0.001);
    }

    @Test
    public void bracketsIncorrect() {

        assertEquals("Incorrect placement of parentheses", NaN, instance.calculate("(43 - 3))"), 0.001);
    }

    @Test
    public void blankExpression() {

        assertEquals("Empty expression", NaN, instance.calculate(""), 0.001);
    }

    @Test
    public void presenceSymbols(){

        assertEquals("The expression contains the characters", NaN, instance.calculate("qwertyu"), 0.001);
    }

    @Test
    public void correctExpression() throws Exception {

        assertEquals("The correct expression", 11, instance.calculate("2+2/4*(25-7)"), 0.001);
    }

}