package Stack;

import java.util.Stack;

public class BracketBalancer {
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false; // Unbalanced: closing bracket without corresponding opening bracket
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false; // Unbalanced: mismatched closing bracket
                }
            }
        }

        return stack.isEmpty(); // Balanced if the stack is empty
    }

    public static void main(String[] args) {
        String expression1 = "{[()]()}";
        String expression2 = "{[()()]";

        boolean isBalanced1 = isBalanced(expression1);
        boolean isBalanced2 = isBalanced(expression2);

        System.out.println(expression1 + " is balanced: " + isBalanced1);
        System.out.println(expression2 + " is balanced: " + isBalanced2);
    }
}
