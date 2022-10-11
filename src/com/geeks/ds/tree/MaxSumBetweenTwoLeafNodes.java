package com.geeks.ds.tree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Given a binary tree, write an efficient algorithm to find the maximum sum of a path between
 * any two leaves in it. Assume that the binary tree is not skewed and contains at-least two nodes.
 */

/* Construct the following tree
              1
            /   \
           /     \
          2       3
           \     / \
           -4   5   6
               / \
              7   8
*/

public class MaxSumBetweenTwoLeafNodes {

    public static void main(String[] args)
    {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(-4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        AtomicInteger max_sum = new AtomicInteger(Integer.MIN_VALUE);
        findMaxSumPath(root, max_sum);

        System.out.println("The max difference between two leaf nodes :"+max_sum.get());
    }

    public static int findMaxSumPath(TreeNode root, AtomicInteger max_sum) {
        if (root == null) {
            return 0;
        }
        int left = findMaxSumPath(root.left, max_sum);
        int right = findMaxSumPath(root.right, max_sum);

        if (root.left == null) {
            return right + root.data;
        }
        if (root.right == null) {
            return left + root.data;
        }
        int cur_sum = left + right + root.data;
        max_sum.set(Math.max(cur_sum, max_sum.get()));

        return Math.max(left, right) + root.data;
    }
}
