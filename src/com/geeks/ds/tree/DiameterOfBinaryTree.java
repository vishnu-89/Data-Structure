package com.geeks.ds.tree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Given a binary tree, write an efficient algorithm to compute the diameter of it.
 * A binary tree diameter equals the total number of nodes on the longest path between any two leaves in it.
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        AtomicInteger diameter = new AtomicInteger(0);
        getDiameter(root, diameter);
        System.out.print("The diameter of the tree is " + diameter.get());
    }

    public static int getDiameter(TreeNode root, AtomicInteger diameter) {

        if(root == null) {
            return 0;
        }

        int leftHeight = getDiameter(root.left, diameter);
        int rightHeight = getDiameter(root.right, diameter);

        int totalDiameter = leftHeight + rightHeight + 1;

        diameter.set(Math.max(diameter.get(), totalDiameter));

        return Math.max(leftHeight,rightHeight) + 1;
    }
}
