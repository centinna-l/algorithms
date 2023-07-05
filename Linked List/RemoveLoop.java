class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class RemoveLoop {
    Node head;

    // Function to detect and remove a loop in a linked list
    public void detectAndRemoveLoop() {
        Node slow = head;
        Node fast = head;

        // Move slow and fast pointers until they meet or reach the end of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast pointers meet, break from the loop
            if (slow == fast) {
                break;
            }
        }

        // If there is no loop in the linked list, return
        if (fast == null || fast.next == null) {
            return;
        }

        // Move slow pointer to the head of the list
        slow = head;

        // Move both pointers one step at a time until they meet again
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        // Set the next pointer of the last node in the loop to null
        fast.next = null;
    }

    // Function to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveLoop list = new RemoveLoop();

        // Create a linked list with a loop
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        // Create a loop by connecting the last node to the second node
        list.head.next.next.next.next.next = list.head.next.next;

        System.out.println("Linked list before removing the loop:");
        list.printList();

        // Detect and remove the loop in the linked list
        list.detectAndRemoveLoop();

        System.out.println("Linked list after removing the loop:");
        list.printList();
    }
}
