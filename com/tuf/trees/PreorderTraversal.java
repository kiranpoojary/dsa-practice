package com.tuf.trees;

public class PreorderTraversal {
    Node root = null;

    public Node insertTreeNode(Node currNode, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (currNode.left == null) {
            currNode.left = new Node(val);
        } else if (currNode.right == null) {
            currNode.right = new Node(val);
        } else {
            insertTreeNode(currNode.left, val);
        }
        return currNode;
    }

    public void preOrderTraversal(Node node) {
        if (node == null)
            return;
        System.out.print(node.value + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void initiateInsertNode(int val) {
        insertTreeNode(this.root, val);

    }

    public void initiatePreOrderTraversal() {
        preOrderTraversal(root);
    }

    public static void main(String[] args) {
        PreorderTraversal tree = new PreorderTraversal();
        tree.initiateInsertNode(20);
        tree.initiateInsertNode(6);
        tree.initiateInsertNode(40);
        tree.initiateInsertNode(16);
        tree.initiateInsertNode(100);
        tree.initiateInsertNode(27);
        tree.initiateInsertNode(211);

        tree.initiatePreOrderTraversal();
    }
}
