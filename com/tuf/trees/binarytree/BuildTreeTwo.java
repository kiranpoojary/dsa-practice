package com.tuf.trees.binarytree;

import java.util.HashMap;

public class BuildTreeTwo {
    // Build tree from provided inorder and preoder traversal
    public static void initiateTreeBuild(int[] preOrder, int[] inOrder) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            mp.put(inOrder[i], i);
        }
        Node root = buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, mp);
        InorderTraversal i = new InorderTraversal();
        System.out.println("In-Order");
        i.inorderTraversal(root);
        System.out.println();
        System.out.println("Post-Order");
        PostorderTraversal p = new PostorderTraversal();
        p.postOrderTraversal(root);

    }

    public static Node buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd,
            HashMap<Integer, Integer> inMapper) {

        if (preStart > preEnd || inStart > inEnd)
            return null;
        Node root = new Node(preOrder[preEnd]);
        int rootIndexInInOrder = inMapper.get(root.value);
        int numsLeft = rootIndexInInOrder - inStart; // 0 indexing
        root.left = buildTree(preOrder, preStart, preStart + numsLeft - 1, inOrder, inStart, rootIndexInInOrder - 1,
                inMapper);
        root.right = buildTree(preOrder, preStart + numsLeft, preEnd - 1, inOrder, rootIndexInInOrder + 1, inEnd,
                inMapper);
        return root;
    }

    public static void main(String[] args) {
        BuildTreeTwo b = new BuildTreeTwo();
        int[] postOrder = { 40, 50, 20, 60, 30, 10 };
        int[] inOrder = { 40, 20, 50, 10, 60, 30 };
        b.initiateTreeBuild(postOrder, inOrder);
    }
}
