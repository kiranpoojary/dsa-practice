package com.tuf.trees.bst;

import javax.swing.tree.TreeNode;

public class KthLargeSmall {
    Node root;

    public void createTree() {
        root = new Node(8);

        root.left = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.left = new Node(6);

        root.right = new Node(12);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

    }

    // for largest in BST
    public void reverseInorder(Node node, int[] counter, int k, int[] kLargest) {
        if (node == null || counter[0] >= k)
            return;

        // Traverse right subtree
        reverseInorder(node.right, counter, k, kLargest);

        // Increment counter after
        // visiting right subtree
        counter[0]++;

        // Check if current node
        // is the Kth largest
        if (counter[0] == k) {
            kLargest[0] = node.value;
            return;
        }

        // Traverse left subtree if
        // Kth largest is not found yet
        reverseInorder(node.left, counter, k, kLargest);
    }

    private void inorder(Node node, int[] counter, int k, int[] kSmallest) {
        if (node == null || counter[0] >= k)
            return;

        // Traverse left subtree
        inorder(node.left, counter, k, kSmallest);

        // Increment counter after visiting left subtree
        counter[0]++;

        // Check if current node is the Kth smallest
        if (counter[0] == k) {
            kSmallest[0] = node.value;
            return;
        }

        // Traverse right subtree if
        // Kth smallest is not found yet
        inorder(node.right, counter, k, kSmallest);
    }

    public int[] findKth(Node root, int k) {
        int[] kSmallest = new int[] { Integer.MIN_VALUE };
        int[] kLargest = new int[] { Integer.MIN_VALUE };
        // Counter to track visited nodes
        int[] counter = new int[] { 0 };

        // Find Kth smallest element
        // (perform inorder traversal)
        inorder(root, counter, k, kSmallest);

        // Reset counter for Kth largest element
        counter[0] = 0;
        // Find Kth largest element: rev inorder
        reverseInorder(root, counter, k, kLargest);

        return new int[] { kSmallest[0], kLargest[0] };
    }

    public static void main(String[] args) {
        KthLargeSmall tree = new KthLargeSmall();
        tree.createTree();
        int k = 3;
        int[] kthElements = tree.findKth(tree.root, k);
        System.out.println("Kth smallest element: " + kthElements[0]);
        System.out.println("Kth largest element: " + kthElements[1]);

    }
}
