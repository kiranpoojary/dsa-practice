package com.tuf.trees.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NodesAtKDistance {
    Node root;

    public void createTree() {
        root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(6);

        root.right = new Node(7);
        root.right.left = new Node(8);
        root.right.right = new Node(9);
        root.right.right.right = new Node(10);
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

    public Queue<Node> getKthNodes(Node fromNode, int k) { // root is from node(to K distance)
        Queue<Node> q = new LinkedList<>();
        if (fromNode == null)
            return q;
        Map<Node, Node> parentMapper = new HashMap<>();
        setParentMapping(root, parentMapper);
        Map<Node, Boolean> visitedNodes = new HashMap<>();
        q.offer(fromNode);
        visitedNodes.put(fromNode, true);
        // System.out.println(visitedNodes.size());
        // System.out.println(parentMapper.size());
        int currK = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            if (currK == k)
                break;
            ++currK;
            for (int i = 0; i < qSize; i++) {
                Node currNode = q.poll();

                // add left
                if (currNode.left != null && visitedNodes.get(currNode.left) == null) {
                    q.offer(currNode.left);
                    visitedNodes.put(currNode.left, true);
                }

                // add right
                if (currNode.right != null && visitedNodes.get(currNode.right) == null) {
                    q.offer(currNode.right);
                    visitedNodes.put(currNode.right, true);
                }

                // add parent
                if (parentMapper.get(currNode) != null && visitedNodes.get(parentMapper.get(currNode)) == null) {
                    // has parent and not visited yet
                    q.offer(parentMapper.get(currNode));
                    visitedNodes.put(parentMapper.get(currNode), true);
                }
            }
        }
        return q;
    }

    public static void main(String[] args) {
        NodesAtKDistance tree = new NodesAtKDistance();
        Queue<Node> nodesAtKthDistance = new LinkedList<>();
        tree.createTree();
        nodesAtKthDistance = tree.getKthNodes(tree.root.right, 1);
        while (!nodesAtKthDistance.isEmpty()) {
            Node n = nodesAtKthDistance.poll();
            System.out.print(n.value + " ");
        }

    }
}
