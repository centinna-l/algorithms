
public class MulLinkedList {

    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node list1, Node list2) {
        list1 = reverse(list1);
        list2 = reverse(list2);

        Node ans = new Node(0);
        Node temp = ans;

        int carry = 0;

        while (list1 != null || list2 != null || carry == 1) {
            int sum = 0;
            if (list1 != null) {
                sum += list1.data;
                list1 = list1.next;
            }
            if (list2 != null) {
                sum += list2.data;
                list2 = list2.next;
            }
            sum += carry;
            carry = sum / 10;
            Node n = new Node(sum % 10);
            temp.next = n;
            temp = temp.next;
        }

        return reverse(ans.next);
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
