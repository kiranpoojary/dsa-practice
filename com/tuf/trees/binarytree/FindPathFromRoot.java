package com.tuf.trees.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

//https://www.youtube.com/watch?v=fmflMqVOC7k&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=98
public class FindPathFromRoot {
    Node root;

    public void createTree() {
        root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(10);
        root.right.right.right = new Node(9);
    }

    public boolean getPathFromRoot(Node root, ArrayList<Integer> path, int findVal) {
        if (root == null) {
            return false;
        }
        path.add(root.value);
        if (root.value == findVal) {
            return true;
        }
        if (getPathFromRoot(root.left, path, findVal) || getPathFromRoot(root.right, path, findVal)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        FindPathFromRoot tree = new FindPathFromRoot();
        tree.createTree();
        ArrayList<Integer> path = new ArrayList<>();
        tree.getPathFromRoot(tree.root, path, 10);
        System.out.println("Path  : " + path);
        ;

    }

}
