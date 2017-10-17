import java.util.regex.*;

public class Formatter
{
    public static void main(String[] args) {

        Formatter string = new Formatter( );
        String text = string.build("If you do not passed the {0} to {1} - it's {2}", "labs", 21, "over");

        System.out.println(text);
    }

    class Container {

        private int IndexOpenQuote;
        private int IndexCloseQuote;
        private String IndexArgument;

        Container(int openQuote, int closeQuote, String indexArgument) {
            this.IndexOpenQuote = openQuote;
            this.IndexCloseQuote = closeQuote;
            this.IndexArgument = indexArgument;
        }

        public int getIndexOpenQuote( ) {
            return this.IndexOpenQuote;
        }

        public int getIndexCloseQuote( ) {
            return this.IndexCloseQuote;
        }

        public String getIndexArgument( ) {
            return this.IndexArgument;
        }

        public void replaceLable(StringBuilder outString) {

            try {
                outString.replace(this.IndexOpenQuote - 1, this.IndexCloseQuote, this.IndexArgument);
            }
            catch (NullPointerException e) {
            }
        }
    }


    public String build(String formatString, Object... arguments) {

        StringBuilder outString = editingFormatString(formatString);

        Container[] arrayString = insertTemplate(formatString, arguments);

        int counter = 0;
        try {
            counter = arguments.length - 1;
            for (Object argument : arguments) {
                if (arrayString[counter] != null) {
                    arrayString[counter].replaceLable(outString);
                }
                counter--;
            }
        }
        catch (NullPointerException e) {
        }

        return outString.toString( );
    }

    private StringBuilder editingFormatString(String formatString) {

        if(formatString == null) {
            StringBuilder outString = new StringBuilder();
            return outString;
        }
        StringBuilder outString = new StringBuilder(formatString);

        return outString;
    }

    private char[] transformationStringToAnArray(String formatString) {
        char[] arrayString = { };
        try {
            arrayString = formatString.toCharArray( );
        }
        catch (NullPointerException e) {
        }

        return arrayString;
    }

    private Container[] editingArrayContainer(Object... arguments) {
        if(arguments == null){
            return null;
        }

        Container[] array = new Container[arguments.length];

        return array;
    }

    private Container[] insertTemplate(String formatString, Object... arguments) {

        char[] arrayString = transformationStringToAnArray(formatString);


        boolean flag = false;
        int countQuote = 0;
        int indexOpen = 0;
        int indexClose = 0;
        int counter = 0;

        Container[] array = editingArrayContainer(arguments);
        StringBuilder indexLabel = new StringBuilder( );

        for (char element : arrayString) {

            countQuote++;
            if (element == '{') {
                indexOpen = countQuote;
                flag = true;
            }
            else {
                if (element == '}') {
                    indexClose = countQuote;
                    flag = false;
                    String temp = indexLabel.toString( );

                    try {
                        int numberArgument = Integer.parseInt(temp);
                        Container exemplar = new Container(indexOpen, indexClose, arguments[numberArgument].toString( ));
                        array[counter] = exemplar;
                        counter++;
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                    }
                    catch (NumberFormatException e) {
                    }

                    indexLabel.delete(0, indexLabel.length( ));
                }

                else {
                    if (flag) {
                        indexLabel.append(element);
                    }
                }
            }
        }

        return array;
    }
}
