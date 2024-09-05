package com.tuf.trees;

import java.util.Stack;

public class IterativePostorderTravOne {
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

    public void initiateNodeInsertion(int val) {
        insertTreeNode(root, val);
    }

    public void iterativePostorderTraversal() {
        if (root == null)
            return;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);

        while (!st1.isEmpty()) {
            Node topNode = st1.pop();
            st2.push(topNode);
            if (topNode.left != null) {
                st1.push(topNode.left);
            }
            if (topNode.right != null)
                st1.push(topNode.right);
        }

        while (!st2.isEmpty()) {
            Node topNode = st2.pop();
            System.out.print(topNode.value + " ");
        }
    }

    public void iterativePostorderTraversalTwo() {
        Node cur = root;
        Stack<Node> st = new Stack<>();
        while (cur != null || !st.isEmpty()) {
            if (cur != null) {
                st.add(cur);
                cur = cur.left;
            } else {
                Node temp = st.peek().right;
                if (temp == null) {
                    temp = st.peek();
                    st.pop();
                    System.out.print(temp.value + " ");
                    while (!st.empty() && temp == st.peek().right) {
                        temp = st.peek();
                        st.pop();
                        System.out.print(temp.value + " ");
                    }
                } else {
                    cur = temp;
                }
            }

        }
    }

    public static void main(String[] args) {
        IterativePostorderTravOne tree = new IterativePostorderTravOne();
        tree.initiateNodeInsertion(44);
        tree.initiateNodeInsertion(30);
        tree.initiateNodeInsertion(144);
        tree.initiateNodeInsertion(90);
        tree.initiateNodeInsertion(26);
        tree.initiateNodeInsertion(445);
        tree.initiateNodeInsertion(48);
        tree.iterativePostorderTraversal();
        System.out.println("\n--With Signle stack--");
        tree.iterativePostorderTraversalTwo();
    }
}
