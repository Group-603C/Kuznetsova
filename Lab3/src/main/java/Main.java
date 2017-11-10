public class Main
{
    public static void main(String[] args)
    {
        String expresion = "4*5-(2+3)";  //21

        Calculator instance = new Calculator();
        double var = instance.calculate(expresion);
        System.out.println("Result: " + var);
    }
}
