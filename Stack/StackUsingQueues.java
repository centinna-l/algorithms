package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int value) {
        // Add the new element to the empty queue
        if (queue1.isEmpty()) {
            queue1.add(value);
        } else {
            // Move all elements from queue1 to queue2
            // and add the new element to queue1
            while (!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }
            queue1.add(value);

            // Move all elements back from queue2 to queue1
            while (!queue2.isEmpty()) {
                queue1.add(queue2.remove());
            }
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.remove();
    }

    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.peek();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top: " + stack.top()); // Output: 3

        stack.pop();
        stack.pop();

        System.out.println("Top: " + stack.top()); // Output: 1
        System.out.println("Is Empty: " + stack.isEmpty()); // Output: false
    }
}
