package com.geeks.ds.tree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Given a binary tree, count all subtrees in it such that every node in the subtree has the same value.
 */

 /* Construct the following tree
                     1
                   /   \
                  2     3
                /     /   \
               4     5     6
             /     /   \     \
            4     5     5     7
 */
public class CountSubTreeOfSameNodeValue {

    public static void main(String[] args)
    {


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        root.right.left.right = new TreeNode(5);
        root.right.right.right = new TreeNode(7);

        AtomicInteger count = new AtomicInteger(0);
        countSubtrees(root,count);
        System.out.print("Total count of node having same value :"+count.get());
    }

    public static int countSubtrees(TreeNode root, AtomicInteger count) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.left == null && root.right == null) {
            count.incrementAndGet();
            return root.data;
        }

        int left = countSubtrees(root.left, count);
        int right = countSubtrees(root.right, count);

        if ( (left == Integer.MIN_VALUE && right == root.data) ||
                (right == Integer.MIN_VALUE && left == root.data) ||
                (left == right && left == root.data) ) {
            count.incrementAndGet();
            return root.data;
        }

        return Integer.MAX_VALUE;
    }
}
