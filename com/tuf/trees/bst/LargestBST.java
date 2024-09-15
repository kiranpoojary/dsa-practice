package com.tuf.trees.bst;

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

// Class to hold information
// about the subtree
class NodeValue {
    int maxNode, minNode, maxSize;

    // Constructor to initialize
    // the NodeValue object
    NodeValue(int minNode, int maxNode, int maxSize) {
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.maxSize = maxSize;
    }
}

class Solution {
    // Helper function to find the
    // largest BST subtree recursively
    private NodeValue largestBSTSubtreeHelper(TreeNode root) {
        // An empty tree is a BST of size 0
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        // Get values from left and right
        // subtrees of the current tree.
        NodeValue left = largestBSTSubtreeHelper(root.left);
        NodeValue right = largestBSTSubtreeHelper(root.right);

        // Check if the current tree is a BST based
        // on its left and right subtrees' properties
        if (left.maxNode < root.val && root.val < right.minNode) {
            // It is a BST, update the values for the current tree
            return new NodeValue(Math.min(root.val, left.minNode),
                    Math.max(root.val, right.maxNode), left.maxSize + right.maxSize + 1);
        }

        // If the current tree is not a BST,
        // return values indicating invalid tree properties
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    // Function to find the size
    // of the largest BST subtree
    public int largestBSTSubtree(TreeNode root) {
        return largestBSTSubtreeHelper(root).maxSize;
    }
}

// Utility function to insert nodes into the BST
class Insert {
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }
}

// Utility function to perform
// inorder traversal of the BST
class InorderTraversal {
    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
}

public class LargestBST {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create the BST
        TreeNode root = null;
        Insert insert = new Insert();
        root = insert.insert(root, 10);
        insert.insert(root, 5);
        insert.insert(root, 15);
        insert.insert(root, 2);
        insert.insert(root, 7);
        insert.insert(root, 12);
        insert.insert(root, 20);

        // Create a new tree, attaching the
        // BST root as the left child of a new root
        TreeNode newRoot = new TreeNode(6);
        newRoot.left = root;
        newRoot.right = new TreeNode(3);

        // Display the original tree using inorder traversal
        InorderTraversal inorderTraversal = new InorderTraversal();
        System.out.print("Original BST: ");
        inorderTraversal.inorderTraversal(newRoot);
        System.out.println();

        // Find the size of the largest BST subtree
        int largestBSTSize = solution.largestBSTSubtree(newRoot);

        // Display the size of the largest BST subtree found
        System.out.println("Size of the largest BST subtree: " + largestBSTSize);
    }
}
