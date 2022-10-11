package com.geeks.ds.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary tree, write an efficient algorithm to find the maximum sum root-to-leaf path, i.e.,
 * the maximum sum path from the root node to any leaf node in it.
 */

/* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            8   4   5   6
               /   / \   \
             10   7   9   5
*/

public class MaximumSumToRoot {

    private static int sum = 0;

    public static void main(String[] args)
    {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(10);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(9);
        root.right.right.right = new TreeNode(5);

        Deque<Integer> queue = new ArrayDeque<>();
        findMaxSumPath(root,queue);

        System.out.print("The maximum sum to leaf node :"+ sum);
    }

    public static void findMaxSumPath(TreeNode root,  Deque<Integer> path) {

        if(root == null) {
            return;
        }
        path.add(root.data);

        if(isLeafNode(root)) {
            int pathSum = path.stream().reduce(0, (subtotal, element) -> subtotal + element);
            sum = Math.max(sum, pathSum);
        }

        findMaxSumPath(root.left , path);
        findMaxSumPath(root.right , path);

        path.removeLast();
    }

    public static boolean isLeafNode(TreeNode root) {
        if(root == null) {
            return false;
        }
        return (root.left == null && root.right == null);
    }

    public static int getRootToLeafSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.data;
        }
        int left = getRootToLeafSum(root.left);
        int right = getRootToLeafSum(root.right);

        return (left > right? left : right) + root.data;
    }
}
