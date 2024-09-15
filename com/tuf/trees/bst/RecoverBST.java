package com.tuf.trees.bst;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class Solution {
    // Store first node of the misplaced pair
    private TreeNode first;
    // Store previous node during inorder traversal
    private TreeNode prev;
    // Store second node of the misplaced pair
    private TreeNode middle;
    // Store last node of the misplaced pair
    private TreeNode last;

    // Helper function to perform inorder
    // traversal and find misplaced nodes
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        // Traverse left subtree
        inorder(root.left);

        // Check for misplaced nodes
        if (prev != null && root.val < prev.val) {
            // If this is the first violation,
            // mark nodes as 'first' and 'middle'
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                // If it's not the first
                // violation, mark 'last'
                last = root;
            }
        }

        // Update 'prev' for the
        // next iteration
        prev = root;
        // Traverse right subtree
        inorder(root.right);
    }

    // Function to recover the binary search tree
    public void recoverTree(TreeNode root) {
        // Initialize node pointers
        first = middle = last = null;
        // Initialize prev with a minimum value
        prev = new TreeNode(Integer.MIN_VALUE);
        // Perform inorder traversal
        inorder(root);

        // Swap the values of misplaced
        // nodes based on conditions
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
}

class RecoverBST {
    // Utility function to
    // insert nodes into the BST
    private static TreeNode insert(TreeNode root, int val) {
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

    // Utility function to perform
    // inorder traversal of the BST
    private static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    // Function to swap two tree
    // nodes and their subtrees
    private static void swapNodes(TreeNode a, TreeNode b) {
        // Swap values of the nodes
        int temp = a.val;
        a.val = b.val;
        b.val = temp;

        // Swap left subtrees of the nodes
        TreeNode tempLeft = a.left;
        a.left = b.left;
        b.left = tempLeft;

        // Swap right subtrees of the nodes
        TreeNode tempRight = a.right;
        a.right = b.right;
        b.right = tempRight;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create the BST
        TreeNode root = null;
        root = insert(root, 3);
        insert(root, 1);
        insert(root, 4);
        insert(root, 2);

        System.out.print("Original BST: ");
        inorderTraversal(root);
        System.out.println();

        // Intentionally swapping two nodes (4 and 2)
        TreeNode node4 = root.right;
        TreeNode node2 = root.left.right;
        swapNodes(node4, node2);

        System.out.print("BST with swapped nodes: ");
        inorderTraversal(root);
        System.out.println();

        // Recover the BST
        solution.recoverTree(root);

        System.out.print("Recovered BST: ");
        inorderTraversal(root);
        System.out.println();
    }
}
