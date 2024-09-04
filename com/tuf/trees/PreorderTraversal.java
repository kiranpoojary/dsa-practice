package com.tuf.trees;

public class PreorderTraversal {
    Node root;

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
        insertTreeNode(root, val);

    }

    public void initiatePreOrderTraversal() {
        preOrderTraversal(root);
    }

    public static void main(String[] args) {
        PreorderTraversal tree = new PreorderTraversal();
        tree.initiateInsertNode(44);
        tree.initiateInsertNode(30);
        tree.initiateInsertNode(144);
        tree.initiateInsertNode(90);
        tree.initiateInsertNode(26);
        tree.initiateInsertNode(445);
        tree.initiateInsertNode(48);

        tree.initiatePreOrderTraversal();
    }
}
