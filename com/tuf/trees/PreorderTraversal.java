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

    public void startPreOrder() {
        preOrderTraversal(root);
    }

    public static void main(String[] args) {
        PreorderTraversal p = new PreorderTraversal();
        p.initiateInsertNode(120);
        p.initiateInsertNode(10);
        p.initiateInsertNode(190);
        p.initiateInsertNode(150);
        p.initiateInsertNode(50);

        p.startPreOrder();
    }
}
