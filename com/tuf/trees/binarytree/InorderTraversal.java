package com.tuf.trees.binarytree;

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
        tree.initiateInsertNode(44);
        tree.initiateInsertNode(30);
        tree.initiateInsertNode(144);
        tree.initiateInsertNode(90);
        tree.initiateInsertNode(26);
        tree.initiateInsertNode(445);
        tree.initiateInsertNode(48);

        tree.initiateInOrderTraversal();
    }

}
