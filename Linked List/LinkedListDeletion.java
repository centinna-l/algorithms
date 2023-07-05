class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
    }
}

public class LinkedListDeletion {
    public static void deleteNode(LinkedListNode nodeToDelete) {
        if (nodeToDelete == null || nodeToDelete.next == null) {
            throw new IllegalArgumentException("Cannot delete the last node or a null node");
        }

        LinkedListNode nextNode = nodeToDelete.next;
        nodeToDelete.data = nextNode.data;
        nodeToDelete.next = nextNode.next;
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node5 = new LinkedListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Delete node3 from the linked list
        deleteNode(node3);

        // Traverse the linked list after deletion
        LinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        // Output: 1 2 4 5
    }
}
