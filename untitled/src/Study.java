public class Study {

    public static void main (String [] args )
    {
        int x=123;
        int y = LatestDigit(x);

        System.out.println(y);
    }

    public static int LatestDigit ( int x)
    {
        int y = (x / 100) + (x % 100 / 10) + (x % 100 % 10) ;
        return y;
    }
}
