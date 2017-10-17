import static org.junit.Assert.*;

public class FormatterTest
{

    @org.junit.Test
    public void build() throws Exception
    {
        Formatter string = new Formatter();

        String outString = "If you do not passed the labs to 21 - it's over";
        String inString = string.build("If you do not passed the {0} to {1} - it's {2}", "labs", 21, "over");

        assertEquals("Test 1",outString, inString);


        outString = "If you do not passed the {0 to 21 - it's over";
        inString = string.build("If you do not passed the {0 to 21 - it's over","labs");
        assertEquals("Test 2",outString, inString);


        outString = "";//
        inString = string.build("", "labs","over");

        assertEquals("Test 3",outString, inString);


        outString = "";
        inString = string.build(null, null);

        assertEquals("Test 4",outString, inString);

        Rectangle rectangle = new Rectangle(2,4);
        outString = "Size 2 * 4";
        inString = string.build(" {0}", rectangle);

        assertEquals("Test 5", outString, inString);
    }

    class Rectangle {
        int width;
        int height;

        Rectangle(int width, int height)
        {
            this.width = width;
            this.height = height;
        }

        @Override
        public String toString()
        {
            return "Size =  " + width + " * " + height;
        }
    }

}