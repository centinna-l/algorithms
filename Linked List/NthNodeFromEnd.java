public class NthNodeFromEnd {
    Node head;

    // Function to find the Nth node from the end of the linked list
    public int findNthNodeFromEnd(int n) {
        if (head == null || n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        Node slow = head;
        Node fast = head;

        // Move the fast pointer n nodes ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                throw new IllegalArgumentException("List size is smaller than n");
            }
            fast = fast.next;
        }

        // Move both pointers until the fast pointer reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

    public static void main(String[] args) {
        NthNodeFromEnd linkedList = new NthNodeFromEnd();

        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        linkedList.head = new Node(1);
        linkedList.head.next = new Node(2);
        linkedList.head.next.next = new Node(3);
        linkedList.head.next.next.next = new Node(4);
        linkedList.head.next.next.next.next = new Node(5);

        int n = 2;
        int nthNodeFromEnd = linkedList.findNthNodeFromEnd(n);
        System.out.println("The " + n + "th node from the end: " + nthNodeFromEnd);
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
