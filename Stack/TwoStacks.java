package Stack;

public class TwoStacks {
    private int[] arr;
    private int size;
    private int top1;
    private int top2;

    public TwoStacks(int capacity) {
        if (capacity < 2) {
            throw new IllegalArgumentException("Capacity must be at least 2");
        }

        arr = new int[capacity];
        size = capacity;
        top1 = -1; // Initialize top index for Stack 1
        top2 = size; // Initialize top index for Stack 2
    }

    public void push1(int value) {
        if (top1 + 1 == top2) {
            throw new StackOverflowError("Stack 1 is full");
        }

        arr[++top1] = value;
    }

    public void push2(int value) {
        if (top2 - 1 == top1) {
            throw new StackOverflowError("Stack 2 is full");
        }

        arr[--top2] = value;
    }

    public int pop1() {
        if (top1 == -1) {
            throw new IllegalStateException("Stack 1 is empty");
        }

        return arr[top1--];
    }

    public int pop2() {
        if (top2 == size) {
            throw new IllegalStateException("Stack 2 is empty");
        }

        return arr[top2++];
    }

    public boolean isEmpty1() {
        return top1 == -1;
    }

    public boolean isEmpty2() {
        return top2 == size;
    }

    public static void main(String[] args) {
        TwoStacks twoStacks = new TwoStacks(6);

        twoStacks.push1(1);
        twoStacks.push1(2);
        twoStacks.push2(3);
        twoStacks.push2(4);

        System.out.println("Pop from Stack 1: " + twoStacks.pop1()); // Output: 2
        System.out.println("Pop from Stack 2: " + twoStacks.pop2()); // Output: 4
    }
}
