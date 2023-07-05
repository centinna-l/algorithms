import java.util.Stack;

class InfixToPostfixConverter {
    public static String convertToPostFix(String expression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == ')') {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(' || stack.peek() == ')') {
                stack.pop();
            } else {
                postfix.append(stack.pop());
            }
        }
        return postfix.toString();
    }

    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}