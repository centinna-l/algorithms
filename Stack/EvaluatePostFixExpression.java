package Stack;

import java.util.Stack;

public class EvaluatePostFixExpression {

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue; // Ignore empty tokens
            }

            if (Character.isDigit(token.charAt(0))) {
                int num = Integer.parseInt(token);

                // Check if the number is out of range
                if (num > 1000) {
                    return -1;
                }

                stack.push(num);
            } else if (token.equals("DUP")) {
                if (!stack.isEmpty()) {
                    int operand = stack.peek();
                    stack.push(operand);
                } else {
                    return -1;
                }
            } else if (token.equals("POP")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return -1;
                }
            } else {
                int operand2 = stack.pop();
                int operand1;

                if (!stack.isEmpty()) {
                    operand1 = stack.pop();
                } else {
                    return -1;
                }

                int result;

                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }

                stack.push(result);
            }
        }

        if (stack.isEmpty()) {
            return -1;
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String postfixExpression = "5 DUP 2 * +";
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result);
    }
}
