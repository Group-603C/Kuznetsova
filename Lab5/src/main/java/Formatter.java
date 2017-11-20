import java.util.ArrayList;
import java.util.Collections;

public class Formatter {

    static String build(String formatString, Object... arguments) {

        if (formatString == null || formatString.equals("")) {
            return "";
        }

        StringBuilder builder = new StringBuilder(formatString);
        ArrayList<Container> reverseContainer = parse(formatString, arguments);
        Collections.reverse(reverseContainer);
        for (Container element : reverseContainer) {

            element.formationMessageRow(builder);
        }

        return builder.toString( );
    }

    static private ArrayList<Container> parse(String formatString, Object... arguments) {

        int indexOPenQuite = 0;
        int currentIndex = 0;
        boolean isReadArgument = false;

        ArrayList<Container> result = new ArrayList<Container>( );
        StringBuilder argumentReader = new StringBuilder( );
        for (char element : formatString.toCharArray( )) {

            currentIndex++;

            if (element == '{') {
                indexOPenQuite = currentIndex;
                isReadArgument = true;
            }
            else if (element == '}' && isReadArgument) {

                isReadArgument = false;
                String storageLabel = argumentReader.toString( );

                try {
                    int numberArgument = Integer.parseInt(storageLabel);
                    result.add(new Container(indexOPenQuite, currentIndex, arguments[numberArgument]));
                }
                catch (IndexOutOfBoundsException e) {
                    throw new IndexOutOfBoundsException("Number of argument our of range.");
                }
                catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Number of argument in bad format.", e);
                }

                argumentReader.delete(0, argumentReader.length( ));
            }
            else if (isReadArgument) {
                argumentReader.append(element);
            }
        }

        return result;
    }

    static class Container {

        private int indexOpenQuote;
        private int indexCloseQuote;
        private Object argument;

        Container(int open, int close, Object argument) {
            this.indexOpenQuote = open;
            this.indexCloseQuote = close;
            this.argument = argument;
        }

        public void formationMessageRow(StringBuilder builder) {

            try {

                builder.replace(this.indexOpenQuote - 1, this.indexCloseQuote, this.argument.toString( ));
            }
            catch (NullPointerException e) {
            }
        }
    }
}