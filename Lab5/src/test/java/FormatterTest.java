import static org.junit.Assert.*;

public class FormatterTest {

    @org.junit.Test
    public void errorInput( ) throws Exception {
        try {

            Formatter errorInput = new Formatter( );

            String value = errorInput.build("", "mom", "dad");
            String expected = "";
            assertEquals("Blank template without labels", expected, value);

            value = errorInput.build("here 0, here {1}, but {2}", "mom", "dad");
            expected = "here 0, here dad, but {2}";
            assertEquals("Instead of the 0 label, the digit 0", expected, value);

            value = errorInput.build("", "");
            expected = "";
            assertEquals("Passing an empty template", expected, value);

            value = errorInput.build(null, null);
            expected = "";
            assertEquals("The pattern and the argument is null", expected, value);

            value = errorInput.build("Without parameters");
            expected = "Without parameters";
            assertEquals("Absence of the parameter", expected, value);
        }
        catch (NumberFormatException e) {
        }
        catch (IndexOutOfBoundsException e) {
        }
    }

    @org.junit.Test
    public void standardInput( ) throws Exception {
        try {

            Formatter standardInput = new Formatter( );

            String value = standardInput.build("here {0} here {1}, but {2}", "mom", "dad", "I");
            String expected = "here mom here dad, but I";
            assertEquals("Correct writing and sending", expected, value);

            value = standardInput.build("Here come {3}, it's time for me to go through {1} of the country, visit {0} Museum and {2} km", 32, 196, 22, 777);
            expected = "Here come 777, it's time for me to go through 196 of the country, visit 32 Museum and 22 km";
            assertEquals("Not consistent arrangement of labels in the template", expected, value);

            value = standardInput.build("Not {2} to take and {3} {0} {1}", "the lab", "Java", "so", "pass", "otherwise");
            expected = "Not so to take and pass the lab Java";
            assertEquals("Parameters more than labels", expected, value);

            value = standardInput.build("here {0} here {1}, but {2}", "mom", "dad");
            expected = "here mom here dad, but {2}";
            assertEquals("Parameters less than labels", expected, value);

            value = standardInput.build("here {0, here {1}, but {2}", "mom", "dad");
            expected = "here {0, here {1}, but {2}";
            assertEquals("Not a closed label", expected, value);
        }
        catch (NumberFormatException e) {
        }
        catch (IndexOutOfBoundsException e) {
        }
    }

    @org.junit.Test
    public void inputValuePrimitive( ) throws Exception {
        try {

            Formatter inputValuePrimitive = new Formatter( );

            String value = inputValuePrimitive.build("Here int value {0}", 20543);
            String expected = "Here int value 20543";
            assertEquals("Parameter of type int", expected, value);

            value = inputValuePrimitive.build("Here the float value is {0}", 0.68f);
            expected = "Here the float value is 0.68";
            assertEquals("Parameter of type float", expected, value);

            value = inputValuePrimitive.build("Here the double value {0}", 3.14d);
            expected = "Here the double value 3.14";
            assertEquals("Parameter of type double", expected, value);

            value = inputValuePrimitive.build("Here boolean value {0}", true);
            expected = "Here boolean value true";
            assertEquals("Parameter of type boolean", expected, value);
        }
        catch (NumberFormatException e) {
        }
        catch (IndexOutOfBoundsException e) {
        }
    }

    @org.junit.Test
    public void inputValueReference( ) throws Exception {

        try {

            Formatter inputValueReference = new Formatter( );

            String value = inputValueReference.build("Here the char value {0}", 'V');
            String expected = "Here the char value V";
            assertEquals("Parameter of type char", expected, value);

            Object objZero = "Object";
            value = inputValueReference.build("Here object the value {0}", objZero);
            expected = "Here object the value Object";
            assertEquals("Parameter of type Object with the number", expected, value);

            Object objOne = 1234.54;
            value = inputValueReference.build("Here object the value {0}", objOne);
            expected = "Here object the value 1234.54";
            assertEquals("Parameter of type Object with the line", expected, value);

            String text = "text";
            value = inputValueReference.build("Here the String value {0}", text);
            expected = "Here the String value text";
            assertEquals("Parameter of type String", expected, value);

            Box box = new Box(111, 222, 333);
            value = inputValueReference.build("Parameter class: {0}", box);
            expected = "Parameter class: size 111 * 222 * 333";
            assertEquals("The transfer of a class with three fields and an overload of toString", expected, value);
        }
        catch (IndexOutOfBoundsException e) {
        }
        catch (NumberFormatException e) {
        }
    }


    class Box {
        int width;
        int height;
        int depth;

        Box(int width, int height, int depth) {
            this.width = width;
            this.height = height;
            this.depth = depth;
        }

        @Override
        public String toString( ) {
            return "size " + width + " * " + height + " * " + depth;
        }
    }
}