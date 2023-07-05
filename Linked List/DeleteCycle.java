public class DeleteCycle {
    Node head;

    // Function to detect and delete a cycle in the linked list
    public void detectAndRemoveCycle() {
        Node slow = head;
        Node fast = head;
        Node cycleStartNode = null;

        // Detect the cycle using Floyd's Cycle-Finding Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {
                cycleStartNode = slow;
                break;
            }
        }

        // If a cycle exists, find the node where the cycle starts
        if (cycleStartNode != null) {
            Node ptr1 = head;
            Node ptr2 = cycleStartNode;

            // Move both pointers until they meet at the cycle start node
            while (ptr1 != ptr2) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }

            // Set the next pointer of the cycle start node to null to remove the cycle
            ptr2.next = null;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeleteCycle linkedList = new DeleteCycle();

        // Create a sample linked list with a cycle: 1 -> 2 -> 3 -> 4 -> 5 -> 3 (points
        // back to 3)
        linkedList.head = new Node(1);
        linkedList.head.next = new Node(2);
        linkedList.head.next.next = new Node(3);
        linkedList.head.next.next.next = new Node(4);
        linkedList.head.next.next.next.next = new Node(5);
        linkedList.head.next.next.next.next.next = linkedList.head.next.next;

        // Detect and remove the cycle
        linkedList.detectAndRemoveCycle();

        System.out.println("Linked List after removing the cycle:");
        linkedList.printList();
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