package Tree;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class SwapBSTNode {
    Node root;
    Node prev;
    Node first;
    Node second;

    public void correctBST() {
        prev = null;
        first = null;
        second = null;

        // Find the swapped nodes
        findSwappedNodes(root);

        // Correct the BST by swapping the values of the two nodes
        if (first != null && second != null) {
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
        }
    }

    private void findSwappedNodes(Node node) {
        if (node == null) {
            return;
        }

        // Inorder traversal
        findSwappedNodes(node.left);

        // Check if current node is smaller than previous node
        if (prev != null && node.data < prev.data) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }

        prev = node;

        findSwappedNodes(node.right);
    }

    public void inorderTraversal(Node node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        SwapBSTNode binaryTree = new SwapBSTNode();

        // Create a sample binary search tree with two nodes swapped
        binaryTree.root = new Node(3);
        binaryTree.root.left = new Node(1);
        binaryTree.root.right = new Node(4);
        binaryTree.root.right.left = new Node(2);
        binaryTree.root.right.right = new Node(5);

        System.out.println("Inorder traversal of the original BST:");
        binaryTree.inorderTraversal(binaryTree.root);
        System.out.println();

        // Correct the BST
        binaryTree.correctBST();

        System.out.println("Inorder traversal of the corrected BST:");
        binaryTree.inorderTraversal(binaryTree.root);
        System.out.println();
    }
}
