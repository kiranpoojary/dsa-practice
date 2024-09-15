package com.tuf.trees.bst;

import javax.swing.tree.TreeNode;

public class DeleteNode {
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

    public Node deleteNode(Node root, int k) {
        if (root == null) {
            return null;
        }
        if (k < root.value) {
            root.left = deleteNode(root.left, k);
        } else if (k > root.value) {
            root.right = deleteNode(root.right, k);
        } else {
            // Node with the value k found
            // Case 1: Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 2: Node with two children
            // Get the inorder successor (smallest in the right subtree)
            Node minNode = getBSTMinNode(root.right);

            // Replace the current node's value with the inorder successor's value
            root.value = minNode.value;

            // Delete the inorder successor from the right subtree
            root.right = deleteNode(root.right, minNode.value);
        }

        return root;
    }

    public Node getBSTMinNode(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        DeleteNode tree = new DeleteNode();
        tree.createTree();
        tree.deleteNode(tree.root, 7);
        TreeTraversal t = new TreeTraversal();
        t.levelOrderTraversal(tree.root);

    }

}
