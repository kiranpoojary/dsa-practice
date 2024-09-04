package com.tuf.trees;

import java.util.Stack;

public class IterativePreorderTrav {
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

    public void initiateInsertNode(int val) {
        insertTreeNode(root, val);
    }

    public void iterativePreorderTraversal() {
        // NO RECURSION
        if (root == null)
            return;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node topNode = st.pop();
            if (topNode.right != null)
                st.push(topNode.right);
            if (topNode.left != null)
                st.push(topNode.left);
            System.out.print(topNode.value + " ");
        }

    }

    public static void main(String[] args) {
        IterativePreorderTrav tree = new IterativePreorderTrav();
        tree.initiateInsertNode(44);
        tree.initiateInsertNode(30);
        tree.initiateInsertNode(144);
        tree.initiateInsertNode(90);
        tree.initiateInsertNode(26);
        tree.initiateInsertNode(445);
        tree.initiateInsertNode(48);
        tree.iterativePreorderTraversal();

    }

}
