package com.tuf.trees;

public class InorderTraversal {
    Node root = null;

    public void insertTreeNode(Node currNode, int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }
        if (currNode.left == null)
            currNode.left = new Node(val);
        else if (currNode.right == null)
            currNode.right = new Node(val);
        else
            insertTreeNode(currNode.left, val);
    }

    public void inorderTraversal(Node currNode) {
        if (currNode == null) {
            return;
        } else {
            inorderTraversal(currNode.left);
            System.out.print(currNode.value + " ");
            inorderTraversal(currNode.right);
        }
    }

    public void initiateInOrderTraversal() {
        inorderTraversal(root);
    }

    public void initiateInsertNode(int val) {
        insertTreeNode(root, val);
    }

    public static void main(String[] args) {
        InorderTraversal tree = new InorderTraversal();
        tree.initiateInsertNode(20);
        tree.initiateInsertNode(6);
        tree.initiateInsertNode(40);
        tree.initiateInsertNode(16);
        tree.initiateInsertNode(100);
        tree.initiateInsertNode(27);
        tree.initiateInsertNode(211);

        tree.initiateInOrderTraversal();
    }

}
