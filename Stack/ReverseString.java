package Stack;

import java.util.Stack;

public class ReverseString {
    public static String reverseString(String input) {
        Stack<Character> stack = new Stack<>();

        // Step 2: Push characters onto the stack
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        // Step 4: Pop characters from the stack and build the reversed string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        String original = "Hello, World!";
        String reversed = reverseString(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}
