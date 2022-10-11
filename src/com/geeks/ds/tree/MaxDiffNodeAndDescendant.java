package com.geeks.ds.tree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Given a binary tree, find the maximum difference between a node and its descendants in it.
 * Assume that the binary tree contains at-least two nodes.
 */

/* Construct the following tree
                  6
                /   \
               /     \
              3       8
                    /   \
                   /     \
                  2       4
                /   \
               /     \
              1       7
*/
public class MaxDiffNodeAndDescendant {

    public static void main(String[] args)
    {


        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(7);

        AtomicInteger diff = new AtomicInteger(Integer.MIN_VALUE);
        findMaxDifference(root, diff);
        System.out.print("The max difference between node and descendant node is :"+diff.get());
    }

    public static int findMaxDifference(TreeNode root, AtomicInteger diff) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int left = findMaxDifference(root.left, diff);
        int right = findMaxDifference(root.right, diff);

        int difference = Integer.MIN_VALUE;
        if (Math.min(left, right) != Integer.MAX_VALUE) {
            difference = root.data - Math.min(left, right);
        }
        diff.set(Math.max(diff.get(), difference));

        return Math.min(Math.min(left, right), root.data);
    }
}
