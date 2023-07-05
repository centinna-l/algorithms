package Tree;

import java.util.ArrayList;
import java.util.List;

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

class CheckBST {
    Node root;

    // Helper function to perform inorder traversal
    private void inorderTraversal(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, list);
        list.add(node.data);
        inorderTraversal(node.right, list);
    }

    // Function to check if a binary tree is a BST or not
    public boolean isBST() {
        List<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);

        for (int i = 1; i < inorderList.size(); i++) {
            if (inorderList.get(i) <= inorderList.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckBST binaryTree = new CheckBST();

        // Create a sample binary tree that is not a BST
        binaryTree.root = new Node(4);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(5);
        binaryTree.root.left.left = new Node(1);
        binaryTree.root.left.right = new Node(3);

        boolean isBST = binaryTree.isBST();
        System.out.println("Is the binary tree a BST? " + isBST);
    }
}
