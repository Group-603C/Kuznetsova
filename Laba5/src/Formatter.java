import java.util.regex.*;

public class Formatter
{
    public static void main(String[] args) {

        Formatter string = new Formatter( );
        String text = string.build("If you do not passed the {0} to {1} - it's {2}", "labs", 21, "over");

        System.out.println(text);
    }

    class Container {

        private int indexOpenQuote;
        private int indexCloseQuote;
        private String indexArgument;

        Container(int openQuote, int closeQuote, String indexArgument) {
            this.indexOpenQuote = openQuote;
            this.indexCloseQuote = closeQuote;
            this.indexArgument = indexArgument;
        }

        public int getIndexOpenQuote( ) {
            return this.indexOpenQuote;
        }

        public int getIndexCloseQuote( ) {
            return this.indexCloseQuote;
        }

        public String getIndexArgument( ) {
            return this.indexArgument;
        }

        public void replaceLable(StringBuilder outString) {

            try {
                outString.replace(this.indexOpenQuote - 1, this.indexCloseQuote, this.indexArgument);
            }
            catch (NullPointerException e) {
            }
        }
    }


    public String build(String formatString, Object... arguments) {

        if(formatString == null){
            return null;
        }

        StringBuilder outString = editingFormatString(formatString);
        Container[] arrayString = insertTemplate(formatString, arguments);

        int counter = 0;

        counter = arguments.length - 1;
        for (Object argument : arguments) {
            if (arrayString[counter] != null) {
                arrayString[counter].replaceLable(outString);
            }
            counter--;
        }

        return outString.toString( );
    }

    private StringBuilder editingFormatString(String formatString) {

        StringBuilder outString = new StringBuilder(formatString);

        return outString;
    }

    private char[] transformationStringToAnArray(String formatString) {
        char[] arrayString = { };

        arrayString = formatString.toCharArray( );

        return arrayString;
    }

    private Container[] editingArrayContainer(Object... arguments) {

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


                    int numberArgument = Integer.parseInt(temp);
                    Container exemplar = new Container(indexOpen, indexClose, arguments[numberArgument].toString( ));
                    array[counter] = exemplar;
                    counter++;

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
