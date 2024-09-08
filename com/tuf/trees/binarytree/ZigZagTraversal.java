package com.tuf.trees.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ZigZagTraversal {
    Node root;

    public void createTree() {
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }

    public void getZigZag(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean fromLeft = true;
        ArrayList<ArrayList<Integer>> zigzag = new ArrayList<>();
        while (!q.isEmpty()) {
            int qSize = q.size();
            Integer[] arr = new Integer[qSize];
            int index = 0;
            for (int i = 0; i < qSize; i++) {
                Node topNode = q.poll();
                index = fromLeft ? i : qSize - i - 1;
                arr[index] = topNode.value;
                if (topNode.left != null)
                    q.add(topNode.left);
                if (topNode.right != null)
                    q.add(topNode.right);
            }
            fromLeft = !fromLeft;
            zigzag.add(new ArrayList<>(Arrays.asList(arr)));
        }
        System.out.println(zigzag);
    }

    public static void main(String[] args) {
        ZigZagTraversal tree = new ZigZagTraversal();
        tree.createTree();
        tree.getZigZag(tree.root);

    }

}
