import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class Calculator
{
    public static void main(String[] args)
    {
        String inString = "(1+2)*4+3";

        System.out.println(Calculate(inString));
    }

    public static double Calculate(String expression)
    {
        Map<String, Double>elementPriority = new HashMap<String, Double>();
        elementPriority.put("(",1d);
        elementPriority.put(")",2d);
        elementPriority.put("+",3d);
        elementPriority.put("-",3d);
        elementPriority.put("*",4d);
        elementPriority.put("/",4d);

        Stack<String> stack = new Stack<>();
        String element;
        String outString = "";

        for(int i=0; i < expression.length(); i++)
        {
            element =  expression.substring(i,i+1);

            if(element.getBytes()[0] >= 48 && element.getBytes()[0] <= 57)
            {
                outString += element;
            }
            else if (stack.empty())
            {
                stack.push(element);
            }
            else
            {
               if(elementPriority.get(stack.peek()) < elementPriority.get(element))
               {
                   stack.push(element);
               }
               else
               {
                   while(!(stack.empty()) && (elementPriority.get(stack.peek()) >= elementPriority.get(element)))
                   {
                       outString +=stack.pop();
                   }
                   stack.push(element);
               }

            }
        }
        while (!stack.empty())
        {
            outString += stack.pop();
        }
        System.out.println(outString);

        Stack<Double> stackRezultat = new Stack<>();
        double otvet=0;

        for(int j=0; j < outString.length(); j++)
        {
            element =  outString.substring(j, j+1);

            if(element.getBytes()[0] >= 48 && element.getBytes()[0] <= 57)
            {
                stackRezultat.push((double) element.charAt(0) - 48);

            }

            else if(element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/"))
            {
                switch(element)
                {
                    case "+":
                        otvet = stackRezultat.pop() + stackRezultat.pop();
                        stackRezultat.push(otvet);
                        break;
                    case "-":
                        otvet = stackRezultat.pop() - stackRezultat.pop();
                        stackRezultat.push(otvet);
                        break;
                    case "*":
                        otvet = stackRezultat.pop() * stackRezultat.pop();
                        stackRezultat.push(otvet);
                        break;
                    case "/":
                        otvet = stackRezultat.pop() / stackRezultat.pop();
                        stackRezultat.push(otvet);
                        break;
                }

            }
        }

        return otvet;
    }
}
