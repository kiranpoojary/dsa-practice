package com.tuf.trees.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinBurnTime {
    Node root;

    public void createTree() {
        root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left.right = new Node(7);

        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
    }

    private static Map<Node, Node> setParentMapping(Node root, Map<Node, Node> parentMapper) {
        if (root == null)
            return parentMapper;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node currNode = q.poll();
            if (currNode.left != null) {
                parentMapper.put(currNode.left, currNode);
                q.offer(currNode.left);
            }
            if (currNode.right != null) {
                parentMapper.put(currNode.right, currNode);
                q.offer(currNode.right);
            }
        }
        return parentMapper;
    }

    public int getMinBurntime(Node fromNode) {
        int time = 0;
        if (fromNode == null)
            return time;
        Map<Node, Node> parentMapper = new HashMap<>();
        Map<Node, Boolean> burnedNodes = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        setParentMapping(root, parentMapper);
        q.offer(fromNode);
        burnedNodes.put(fromNode, true);
        boolean burned = false;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Node curNode = q.poll();
                // up
                if (parentMapper.get(curNode) != null && burnedNodes.get(parentMapper.get(curNode)) == null) {
                    q.offer(parentMapper.get(curNode));
                    burnedNodes.put(parentMapper.get(curNode), true);
                    burned = true;
                }
                // left
                if (curNode.left != null && burnedNodes.get(curNode.left) == null) {
                    q.offer(curNode.left);
                    burnedNodes.put(curNode.left, true);
                    burned = true;
                }
                // right
                if (curNode.right != null && burnedNodes.get(curNode.right) == null) {
                    q.offer(curNode.right);
                    burnedNodes.put(curNode.right, true);
                    burned = true;
                }

            }
            if (burned) {
                ++time;
            }
            burned = false;
        }
        return time;
    }

    public static void main(String[] args) {
        MinBurnTime tree = new MinBurnTime();
        tree.createTree();
        System.out.println("Min Burn Time   : " + tree.getMinBurntime(tree.root.left.left.right));

    }

}
