package com.tuf.trees.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.tuf.searching.bs.MinimizeGasStationDistance.Pair;

public class TraversalAll {
    Node root;

    public Node insertTreeNode(Node currNode, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (currNode.left == null) {
            currNode.left = new Node(val);
            return currNode.left;
        } else if (currNode.right == null) {
            currNode.right = new Node(val);
            return currNode.right;
        } else {
            return insertTreeNode(currNode.left, val);
        }
    }

    public Node initiateInsertNode(int val) {
        return insertTreeNode(root, val);
    }

    public void initiateStructuredInsertNode(int val1, int val2, int val3, int val4, int val5, int val6, int val7) {
        root = new Node(val1);
        root.left = new Node(val2);
        root.left.left = new Node(val3);
        root.left.right = new Node(val4);
        root.right = new Node(val5);
        root.right.left = new Node(val6);
        root.right.right = new Node(val7);
    }

    public void getAllTraversal() {
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        Stack<NodePair> st = new Stack<>();
        if (root == null)
            return;
        NodePair n = new NodePair(root, 1);
        st.push(n);
        while (!st.isEmpty()) {
            NodePair top = st.peek();
            int count = top.getCount();
            Node node = top.getNode();
            switch (count) {
                case 1:
                    preOrder.add(top.getNode().value);
                    top.setCount((top.setCount(++count)));
                    if (node.left != null) {
                        NodePair newpair = new NodePair(node.left, 1);
                        st.add(newpair);
                    }
                    break;
                case 2:
                    inOrder.add(top.getNode().value);
                    top.setCount((top.setCount(++count)));
                    if (node.right != null) {
                        NodePair newpair = new NodePair(node.right, 1);
                        st.add(newpair);
                    }
                    break;
                case 3:
                    postOrder.add(top.getNode().value);
                    st.pop();
                    break;

                default:
                    st.pop();
                    break;
            }

        }
        System.out.println("Pre Order    :" + preOrder);
        System.out.println("In Order     :" + inOrder);
        System.out.println("Post Order   :" + postOrder);
    }

    public static void main(String[] args) {
        TraversalAll tree = new TraversalAll();
        tree.initiateStructuredInsertNode(1, 2, 3, 4, 5, 6, 7);
        tree.getAllTraversal();
    }
}
