package com.tuf.trees;

public class PostorderTraversal {
    Node root;

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

    public void postOrderTraversal(Node currNode) {
        if (currNode == null)
            return;
        postOrderTraversal(currNode.left);
        postOrderTraversal(currNode.right);
        System.out.print(currNode.value + " ");
    }

    public void initiateInsertNode(int val) {
        insertTreeNode(root, val);
    }

    public void initiatePostOrderTraversal() {
        postOrderTraversal(root);
    }

    public static void main(String[] args) {
        PostorderTraversal tree = new PostorderTraversal();
        tree.initiateInsertNode(44);
        tree.initiateInsertNode(30);
        tree.initiateInsertNode(144);
        tree.initiateInsertNode(90);
        tree.initiateInsertNode(26);
        tree.initiateInsertNode(445);
        tree.initiateInsertNode(48);
        tree.initiatePostOrderTraversal();

    }
}
