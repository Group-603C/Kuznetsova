public class Main {

    public static void main(String[] args) {

        Formatter exemplar = new Formatter( );
        try {

            String instance = exemplar.build("здесь {0}, а здесь {1}, а вот {2}", "мама", "папа");
        }
        catch (IndexOutOfBoundsException e) {
        }
        catch (NumberFormatException e) {
        }
    }
}