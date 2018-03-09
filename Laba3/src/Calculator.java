import java.util.ArrayList;
import java.util.Stack;

public class Calculator {

    public static double calculate(String expression) {

        if (!isCorrect(expression)) {
            return Double.NaN;
        }

        Stack<Character> stack = new Stack<>();
        ArrayList<String> postfixExpression = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (Character.isDigit(symbol)) {// определяет, является ли указанное значение типа char цифрой.
                int counter = 0;
                while (i + counter != expression.length() && Character.isDigit(expression.charAt(i + counter))) {
                    counter++;
                }
                postfixExpression.add(expression.substring(i, i + counter));
                i += counter - 1;
            }
            else if (symbol == '(') {
                stack.push(symbol);
            }
            else if (symbol == ')') {
                while (stack.peek() != '(') {
                    postfixExpression.add(stack.pop().toString());
                }
                stack.pop();
            }
            else if (isEmpty(symbol)) {
                while (!stack.empty() && operatorPriority(symbol) <= operatorPriority(stack.peek())) {
                    postfixExpression.add(stack.pop().toString());
                }
                stack.push(symbol);
            }
        }

        while (!stack.empty()) {
            postfixExpression.add(stack.pop().toString());
        }
        if (postfixExpression.size() == 0) {

            return Double.NaN;
        }
        return postfixCalculate(postfixExpression);
    }

    private static double postfixCalculate(ArrayList<String> expression) {

        Stack<Double> stack = new Stack<>();
        for (String i : expression) {

            if (isNumber(i)) {

                stack.push(Double.parseDouble(i));
            }
            else if (stack.size() < 2) {

                return Double.NaN;
            }
            else {

                double secondNumber = stack.pop();
                switch (i) {

                    case "+":
                        stack.push(stack.pop() + secondNumber);
                        break;
                    case "-":
                        stack.push(stack.pop() - secondNumber);
                        break;
                    case "*":
                        stack.push(stack.pop() * secondNumber);
                        break;
                    case "/":
                        if (secondNumber == 0) {

                            return Double.NaN;
                        }
                        stack.push(stack.pop() / secondNumber);
                }
            }
        }

        return stack.pop();
    }

    private static int operatorPriority(char operation) {

        switch (operation) {

            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;

            default:
                return 0;
        }
    }

    private static boolean isCorrect(String expression) {

        if (expression == null) {

            return false;
        }

        int counter = 0;
        for(char symbol:expression.toCharArray()){

            if (symbol == '(') {

                counter++;
            }
            else if (symbol == ')') {

                if (counter < 1) {

                    return false;
                }
                counter--;
            }
            else if (isNumber(Character.toString(symbol)) && isOperator(symbol)) {

                return false;
            }
        }

        if (counter > 0) {

            return false;
        }

        return true;
    }

    private static boolean isOperator(char operation) {

        return operatorPriority(operation) > 0;
    }

    //private static boolean isOperator(char operation) {

    //    return operation == '+' || operation == '-' || operation == '/' || operation == '*';
    //}

    private static boolean isEmpty(char symbol) {

        return symbol != ' ';
    }

    private static boolean isNumber(String number) {

        try {

            Double.parseDouble(number);
            return true;
        }
        catch (NumberFormatException e) {

            return false;
        }
    }


}
