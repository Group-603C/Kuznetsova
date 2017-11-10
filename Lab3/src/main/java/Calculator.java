import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator
{
    private static Map<String, Double> dictionaryPriority = priorities();

    private static Map priorities()
    {
        dictionaryPriority = new HashMap<String, Double>();
        dictionaryPriority.put("(", 1d);
        dictionaryPriority.put(")", 2d);
        dictionaryPriority.put("+", 3d);
        dictionaryPriority.put("-", 3d);
        dictionaryPriority.put("*", 4d);
        dictionaryPriority.put("/", 4d);

        return dictionaryPriority;
    }

    private static ArrayList<String> divisionArray(String expression)
    {
        String storageExpression = "";
        ArrayList<String> expressionToList = new ArrayList<String>();

        char[] expressionToChar = expression.replaceAll(" ", "").replaceAll(",", ".").toCharArray();

        for (int i = 0; i < expressionToChar.length; i++)
        {
            if (expressionToChar[i] != '+' && expressionToChar[i] != '-' && expressionToChar[i] != '/' && expressionToChar[i] != '*' && expressionToChar[i] != '(' && expressionToChar[i] != ')')
            {
                storageExpression += expressionToChar[i];
                continue;
            }
            if (expressionToChar[i] == '.')
            {
                storageExpression += expressionToChar[i];
                continue;
            }

            expressionToList.add(storageExpression);
            storageExpression = "" + expressionToChar[i];

            expressionToList.add(storageExpression);
            storageExpression = "";
        }
        expressionToList.add(storageExpression);



        while (expressionToList.contains(""))
        {
            expressionToList.remove("");
        }

        return expressionToList;
    }

    private static ArrayList<String> infixToPostfix(String expression)
    {
        ArrayList<String> expressionToList = divisionArray(expression);

        ArrayList<String> expressionToChar = new ArrayList<String>();  //здесь элементы постфиксной записи
        Stack<String> stackSymbol = new Stack<String>();  //здесь операции для стека


        for (String element : expressionToList)
        {
            try
            {
                double checkNumber = Double.parseDouble(element);
                expressionToChar.add(element);
            }
            catch (NumberFormatException e)
            {
                if (stackSymbol.size() == 0 || stackSymbol.peek().equals("("))
                {
                    stackSymbol.push(element);
                    continue;
                }

                if (dictionaryPriority.get(element) > dictionaryPriority.get(stackSymbol.peek()))
                {
                    stackSymbol.push(element);
                    continue;
                }

                if (dictionaryPriority.get(element) <= dictionaryPriority.get(stackSymbol.peek()))
                {
                    if (dictionaryPriority.get(stackSymbol.peek()) < dictionaryPriority.get(element) || stackSymbol.peek().equals("("))
                    {
                        while (dictionaryPriority.get(stackSymbol.peek()) < dictionaryPriority.get(element))
                        {
                            expressionToChar.add(stackSymbol.pop());
                        }
                    }
                    else
                    {
                        expressionToChar.add(stackSymbol.pop());
                    }

                    stackSymbol.push(element);
                    continue;
                }

                if (element.equals(")"))
                {
                    String skobka = "(";
                    for (; ; )
                    {
                        if (stackSymbol.peek().equals(skobka))
                        {
                            stackSymbol.pop();
                            break;
                        }
                        else
                        {
                            expressionToChar.add(stackSymbol.pop());
                        }
                    }
                }
            }
        }

        while (stackSymbol.size() != 0)
        {
            expressionToChar.add(stackSymbol.pop());
        }
        System.out.println(expressionToChar);

        return expressionToChar;
    }

    public double calculate(String expression)
    {
        ArrayList<String> expressionToChar = infixToPostfix(expression);

        double resultCalcPostfix = 0d;

        Stack<Double> stackCalculate = new Stack<Double>();

        for (int i = 0; i < expressionToChar.size(); i++)
        {
            try
            {
                double temp = Double.parseDouble(expressionToChar.get(i));
                stackCalculate.push(temp);
                System.out.println(stackCalculate);
            }
            catch (NumberFormatException e)
            {
                if (expressionToChar.get(i).contains("+"))
                {
                    resultCalcPostfix = stackCalculate.pop() + stackCalculate.pop();
                    stackCalculate.push(resultCalcPostfix);
                }
                else if (expressionToChar.get(i).contains("-"))
                {
                    double var0 = stackCalculate.pop();
                    double var1 = stackCalculate.pop();
                    resultCalcPostfix = var1 - var0;
                    stackCalculate.push(resultCalcPostfix);
                }
                else if (expressionToChar.get(i).contains("*"))
                {
                    resultCalcPostfix = stackCalculate.pop() * stackCalculate.pop();
                    stackCalculate.push(resultCalcPostfix);
                }
                else if (expressionToChar.get(i).contains("/"))
                {
                    double var0 = stackCalculate.pop();
                    double var1 = stackCalculate.pop();
                    if (var1 == 0d)
                    {
                        resultCalcPostfix = Double.MIN_VALUE;
                    }
                    else
                    {
                        resultCalcPostfix = var1 / var0;
                    }
                    stackCalculate.push(resultCalcPostfix);
                }
            }
        }

        return resultCalcPostfix;
    }
}
